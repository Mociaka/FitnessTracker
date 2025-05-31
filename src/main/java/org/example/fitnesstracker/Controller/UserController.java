package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.UserCredential;
import org.example.fitnesstracker.DTO.UserDTOResponse;
import org.example.fitnesstracker.DTO.UsersDTOUpload;
import org.example.fitnesstracker.DTO.WorkoutDTOResponse;
import org.example.fitnesstracker.Service.UserService;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.models.Workout;
import org.example.fitnesstracker.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUser(@PathVariable long id) {
//        return ResponseEntity.ok(userService.findById(id));
//    }

//    @GetMapping
//    public ResponseEntity<List<Users>> getUsers() {
//        return ResponseEntity.ok(userService.findAll());
//    }

    @GetMapping("/info")
    public ResponseEntity<?> getMyInfo() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Users userByEmail = userService.findByEmail(email);
        return ResponseEntity.ok(new UserDTOResponse(
                userByEmail.getId(),
                userByEmail.getUsername(),
                userByEmail.getEmail(),
                userByEmail.getPassword(),
                userByEmail.getWeight(),
                userByEmail.getHeight(),
                userByEmail.getBirthDate()
        ));
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
//    }\\\\

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        if (email.equals(userService.findByEmail(email).getEmail()))
            userService.delete(id);

        return ResponseEntity.ok("User deleted");
    }

    @GetMapping("/workouts")
    public ResponseEntity<?> getMyWorkouts() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Workout> userWorkouts = userService.getUserWorkouts(email);
        List<WorkoutDTOResponse> workoutDTOResponses = userWorkouts.stream().map(workout ->
            new WorkoutDTOResponse(
                    workout.getId(),
                    workout.getDate(),
                    workout.getNotes(),
                    workout.getType(),
                    workout.getExercises()
            )
        ).toList();
        return ResponseEntity.ok(workoutDTOResponses);
    }

    @GetMapping("/nutritions")
    public ResponseEntity<?> getMyNutritions() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(userService.getUserNutritions(email));
    }


}
