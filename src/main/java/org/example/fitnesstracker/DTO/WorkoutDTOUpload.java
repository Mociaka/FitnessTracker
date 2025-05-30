package org.example.fitnesstracker.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.fitnesstracker.models.Exercise;
import org.example.fitnesstracker.models.TypeOfExercise;
import org.example.fitnesstracker.models.Users;

import java.time.LocalDate;
import java.util.List;

@Data
public class WorkoutDTOUpload {
    private LocalDate date;
    private String notes;

    private TypeOfExercise typeOfExercise; // Наприклад: Cardio, Strength

//    private List<Exercise> exercises;

}
