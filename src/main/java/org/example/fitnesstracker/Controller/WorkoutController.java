package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.WorkoutDTOResponse;
import org.example.fitnesstracker.DTO.WorkoutDTOUpload;
import org.example.fitnesstracker.DTO.typeOfExerciseDTOUpload;
import org.example.fitnesstracker.Service.TypeOfExerciseService;
import org.example.fitnesstracker.Service.UserService;
import org.example.fitnesstracker.Service.WorkoutService;
import org.example.fitnesstracker.models.Workout;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/workout")
@RestController
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;
    private final UserService userService;



    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {

        Workout byId = workoutService.findById(id);

        return ResponseEntity.ok(new WorkoutDTOResponse(
                byId.getId(),
                byId.getDate(),
                byId.getNotes(),
                byId.getType(),
                byId.getExercises()
        ));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Workout> workouts = workoutService.findAll();
        return ResponseEntity.ok(workouts.stream()
            .map(workout -> new WorkoutDTOResponse(
                    workout.getId(),
                    workout.getDate(),
                    workout.getNotes(),
                    workout.getType(),
                    workout.getExercises()
            )).toList());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody WorkoutDTOUpload upload) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        workoutService.save(upload, userService.findByEmail(email));
        return ResponseEntity.ok("Created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        workoutService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
