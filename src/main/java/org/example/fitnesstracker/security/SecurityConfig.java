package org.example.fitnesstracker.security;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepo userRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtRequestFilter jwtRequestFilter) throws Exception {
        return http
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/v1/user/login", "api/v1/user/register").permitAll()
                        .requestMatchers("api/v1/user/{id}", "api/v1/user/**").hasRole("USER")
                        .requestMatchers("api/v1/workout", "api/v1/workout/**").hasRole("USER")
                        .requestMatchers("api/v1/exercise/**").hasRole("USER")
                        .requestMatchers( HttpMethod.GET, "api/v1/type-of-exercise").permitAll()
                        .requestMatchers("api/v1/type-of-exercise/**", "api/v1/type-of-exercise").hasRole("USER")
                        .requestMatchers("api/v1/nutrition/**", "api/v1/nutrition").hasRole("USER")
                        .requestMatchers("api/v1/goal/**", "api/v1/goal").hasRole("USER")
                        .requestMatchers(HttpMethod.PATCH, "api/v1/goal/**").hasRole("USER")


                )
                .formLogin(formlogin -> formlogin.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userRepo);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}
