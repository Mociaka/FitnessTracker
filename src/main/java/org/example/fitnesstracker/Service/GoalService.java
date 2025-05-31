package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.GoalDTOUpload;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.models.Goal;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.repository.GoalRepo;
import org.example.fitnesstracker.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepo goalRepo;
    private final UserRepo userRepo;

    public List<Goal> getMyGoals(String email) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new NotFoundDatabaseException("User not found"));
        return goalRepo.findAllByUsers(user);
    }

    public void create(String email, GoalDTOUpload dto) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new NotFoundDatabaseException("User not found"));

        Goal goal = new Goal();
        goal.setTitle(dto.getTitle());
        goal.setDescription(dto.getDescription());
        goal.setTargetDate(dto.getTargetDate());
        goal.setAchieved(false);
        goal.setUsers(user);

        goalRepo.save(goal);
    }

    public void delete(long id) {
        goalRepo.deleteById(id);
    }
    public void markAsAchieved(Long goalId, String email) {
        Goal goal = goalRepo.findById(goalId)
                .orElseThrow(() -> new NotFoundDatabaseException("Goal not found"));

        if (!goal.getUsers().getEmail().equals(email)) {
            throw new SecurityException("You can update only your goals");
        }

        goal.setAchieved(true);
        goalRepo.save(goal);
    }

}
