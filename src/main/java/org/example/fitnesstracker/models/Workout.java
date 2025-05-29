package org.example.fitnesstracker.models;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
public class Workout {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private String notes;

    @ManyToOne
    private TypeOfExercise typeOfExercise; // Наприклад: Cardio, Strength
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL.ALL)
    private List<Exercise> exercises;
}
