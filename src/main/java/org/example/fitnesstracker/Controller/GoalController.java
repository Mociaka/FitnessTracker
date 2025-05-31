package org.example.fitnesstracker.Controller;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.GoalDTOUpload;
import org.example.fitnesstracker.Service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @GetMapping
    public ResponseEntity<?> getMyGoals() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(goalService.getMyGoals(email));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GoalDTOUpload dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        goalService.create(email, dto);
        return ResponseEntity.ok("Goal created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        goalService.delete(id);
        return ResponseEntity.ok("Goal deleted");
    }
    @PatchMapping("/{id}/achieve")
    public ResponseEntity<?> markGoalAsAchieved(@PathVariable Long id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        goalService.markAsAchieved(id, email);
        return ResponseEntity.ok("Goal marked as achieved");
    }

}
