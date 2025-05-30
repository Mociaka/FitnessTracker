package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.WorkoutDTOUpload;
import org.example.fitnesstracker.DTO.typeOfExerciseDTOUpload;
import org.example.fitnesstracker.Service.TypeOfExerciseService;
import org.example.fitnesstracker.Service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/workout")
@RestController
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;



    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(workoutService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(workoutService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody WorkoutDTOUpload upload) {
        workoutService.save(upload, null);
        return ResponseEntity.ok("Created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        workoutService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
