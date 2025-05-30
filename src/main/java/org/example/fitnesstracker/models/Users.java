package org.example.fitnesstracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @NotNull
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private Double weight;
    private Double height;
    private LocalDate birthDate;
    private String role;

    @OneToMany(mappedBy = "users")
    private List<Workout> workouts;

    @OneToMany(mappedBy = "users")
    private List<NutritionLog> nutritionLogs;

    @OneToMany(mappedBy = "users")
    private List<Goal> goals;
}
