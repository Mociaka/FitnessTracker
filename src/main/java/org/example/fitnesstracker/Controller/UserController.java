package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.UsersDTOUpload;
import org.example.fitnesstracker.Service.UserService;
import org.example.fitnesstracker.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UsersDTOUpload user) {
        userService.save(user);
        return ResponseEntity.ok("User created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }

}
