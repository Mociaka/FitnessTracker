package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.WorkoutDTOUpload;
import org.example.fitnesstracker.DTO.typeOfExerciseDTOUpload;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.models.Workout;
import org.example.fitnesstracker.repository.WorkoutRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepo workoutRepo;

    public Workout findById(long id) {
        return workoutRepo.findById(id).orElseThrow(() ->
                new NotFoundDatabaseException("Workout not found by id: " + id));
    }

    public List<Workout> findAll() {
        return workoutRepo.findAll();
    }

    public void save(WorkoutDTOUpload upload, Users user) {
        workoutRepo.save(new Workout(
                null,
                upload.getDate(),
                upload.getNotes(),
                upload.getType(),
                user,
                null
        ));
    }

    public void delete(long id) {
        workoutRepo.deleteById(id);
    }
}
