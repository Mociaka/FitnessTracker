package org.example.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Goal {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean achieved;

    @ManyToOne
    private User user;
}
