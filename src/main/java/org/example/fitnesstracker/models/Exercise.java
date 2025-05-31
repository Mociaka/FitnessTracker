package org.example.fitnesstracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer sets;
    private Integer reps;
    private Double weight; // optional

    @ManyToOne
    private TypeOfExercise typeOfExercise;

    @ManyToOne
    @JsonIgnore
    private Workout workout;
}
