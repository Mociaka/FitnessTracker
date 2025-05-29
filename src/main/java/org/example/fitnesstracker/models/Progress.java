package org.example.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Progress {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private Double weight;
    private Double bodyFatPercentage; // optional

    @ManyToOne
    private User user;
}
