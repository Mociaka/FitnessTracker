package org.example.fitnesstracker.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTOUpload {
    private String name;
    private Integer sets;
    private Integer reps;
    private Double weight;
    private Long workoutId; // посилання на тренування
    private Long typeOfExerciseId;
}
