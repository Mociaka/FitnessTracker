package org.example.fitnesstracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private String notes;

    @ManyToOne
    private TypeOfExercise typeOfExercise; // Наприклад: Cardio, Strength
    @ManyToOne
    private Users users;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Exercise> exercises;
}
