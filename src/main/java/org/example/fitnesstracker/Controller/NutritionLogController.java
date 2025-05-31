package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.NutritionLogDTOUpload;
import org.example.fitnesstracker.Service.NutritionLogService;
import org.example.fitnesstracker.Service.UserService;
import org.example.fitnesstracker.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/nutrition")
@RequiredArgsConstructor
public class NutritionLogController {

    private final NutritionLogService nutritionLogService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nutritionLogService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NutritionLogDTOUpload dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        nutritionLogService.create(email, dto);
        return ResponseEntity.ok("Created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.findByEmail(email);
        if (email.equals(nutritionLogService.findByUser(user).getEmail()))
        nutritionLogService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
