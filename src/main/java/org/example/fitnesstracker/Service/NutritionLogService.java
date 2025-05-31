package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.NutritionLogDTOUpload;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.models.NutritionLog;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.repository.NutritionLogRepo;
import org.example.fitnesstracker.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NutritionLogService {
    private final NutritionLogRepo nutritionLogRepo;
    private final UserRepo userRepo;

    public List<NutritionLog> getMyLogs(String email) {
        Users user = userRepo.findByEmail(email).orElseThrow(() ->
                new NotFoundDatabaseException("User not found")
        );
        return nutritionLogRepo.findAllByUsers(user);
    }

    public List<NutritionLog> findAll(){
        return nutritionLogRepo.findAll();
    }

    public void create(String email, NutritionLogDTOUpload dto) {
        Users user = userRepo.findByEmail(email).orElseThrow(() ->
                new NotFoundDatabaseException("User not found")
        );

        NutritionLog log = new NutritionLog();
        log.setDate(dto.getDate());
        log.setCalories(dto.getCalories());
        log.setProtein(dto.getProtein());
        log.setCarbs(dto.getCarbs());
        log.setFat(dto.getFat());
        log.setNotes(dto.getNotes());
        log.setUsers(user);

        nutritionLogRepo.save(log);
    }

    public void delete(long id) {
        nutritionLogRepo.deleteById(id);
    }

    public Users findByUser(Users user) {
            return userRepo.findByEmail(user.getEmail()).orElseThrow(() ->  new NotFoundDatabaseException("User not found"));
    }
}
