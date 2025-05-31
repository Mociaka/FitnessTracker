package org.example.fitnesstracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.fitnesstracker.models.Exercise;
import org.example.fitnesstracker.models.TypeOfExercise;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class WorkoutDTOResponse {

    private Long id;
    private LocalDate date;
    private String notes;

    private String  type; // Наприклад: Cardio, Strength
    private List<Exercise> exercises;
}
