package org.example.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer sets;
    private Integer reps;
    private Double weight; // optional

    @ManyToOne
    private Workout workout;
}
