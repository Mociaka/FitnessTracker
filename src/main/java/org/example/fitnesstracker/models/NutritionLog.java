package org.example.fitnesstracker.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class NutritionLog {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private Integer calories;
    private Integer protein;
    private Integer carbs;
    private Integer fat;
    private String notes;

    @ManyToOne
    private User user;
}
