package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.ExerciseDTOUpload;
import org.example.fitnesstracker.DTO.ExerciseDTOResponse;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.models.Exercise;
import org.example.fitnesstracker.models.TypeOfExercise;
import org.example.fitnesstracker.models.Workout;
import org.example.fitnesstracker.repository.ExerciseRepo;
import org.example.fitnesstracker.repository.TypeOfExerciseRepo;
import org.example.fitnesstracker.repository.WorkoutRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;
    private final WorkoutRepo workoutRepo;
    private final TypeOfExerciseRepo typeOfExerciseRepo;

    public List<ExerciseDTOResponse> findAll() {
        return exerciseRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ExerciseDTOResponse findById(Long id) {
        Exercise ex = exerciseRepo.findById(id)
                .orElseThrow(() -> new NotFoundDatabaseException("Exercise not found with id: " + id));
        return toDTO(ex);
    }

    public ExerciseDTOResponse save(ExerciseDTOUpload upload) {
        Workout workout = workoutRepo.findById(upload.getWorkoutId())
                .orElseThrow(() -> new NotFoundDatabaseException("Workout not found with id: " + upload.getWorkoutId()));
        TypeOfExercise typeOfExercise = typeOfExerciseRepo.findById(upload.getTypeOfExerciseId())
                .orElseThrow(() -> new NotFoundDatabaseException("type of Exercise not found with id: " + upload.getTypeOfExerciseId()));

        Exercise exercise = new Exercise();
        exercise.setName(upload.getName());
        exercise.setReps(upload.getReps());
        exercise.setSets(upload.getSets());
        exercise.setWeight(upload.getWeight());
        exercise.setWorkout(workout);
        exercise.setTypeOfExercise(typeOfExercise);

        return toDTO(exerciseRepo.save(exercise));
    }

    public void delete(Long id) {
        exerciseRepo.deleteById(id);
    }

    private ExerciseDTOResponse toDTO(Exercise ex) {
        return new ExerciseDTOResponse(
                ex.getId(),
                ex.getName(),
                ex.getSets(),
                ex.getReps(),
                ex.getWeight(),
                ex.getWorkout().getId()
        );
    }
}
