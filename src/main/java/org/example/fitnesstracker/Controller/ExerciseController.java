package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.ExerciseDTOUpload;
import org.example.fitnesstracker.DTO.ExerciseDTOResponse;
import org.example.fitnesstracker.Service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExerciseDTOResponse>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTOResponse> getExerciseById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ExerciseDTOResponse> createExercise(@RequestBody ExerciseDTOUpload upload) {
        return ResponseEntity.ok(exerciseService.save(upload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable Long id) {
        exerciseService.delete(id);
        return ResponseEntity.ok("Exercise deleted successfully");
    }
}
