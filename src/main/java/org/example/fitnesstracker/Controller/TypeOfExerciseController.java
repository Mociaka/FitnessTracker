package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.typeOfExerciseDTOUpload;
import org.example.fitnesstracker.Service.TypeOfExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/type-of-exercise")
@RestController
@RequiredArgsConstructor
public class TypeOfExerciseController {
    private final TypeOfExerciseService typeOfExerciseService;



    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeOfExercise(@PathVariable long id) {
        return ResponseEntity.ok(typeOfExerciseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllTypeOfExercise() {
        return ResponseEntity.ok(typeOfExerciseService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createTypeOfExercise(@RequestBody typeOfExerciseDTOUpload upload) {
        typeOfExerciseService.save(upload);
        return ResponseEntity.ok("Created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTypeOfExercise(@PathVariable long id) {
        typeOfExerciseService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
