package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.UserCredential;
import org.example.fitnesstracker.DTO.UsersDTOUpload;
import org.example.fitnesstracker.Service.UserService;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UsersDTOUpload user) {
        Users registered = userService.register(user);
        return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail(), registered.getRole()));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredential user) {
        Users byEmail = userService.findByEmail(user.getEmail());
        String token = jwtUtil.generateToken(user.getEmail(), byEmail.getRole());
        return ResponseEntity.ok(token);
    }

//    @PostMapping("/update")
//    public ResponseEntity<?> createUser(@RequestBody UsersDTOUpload user) {
//        userService.register(user);
//        return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail(), user.getPassword()));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }

}
