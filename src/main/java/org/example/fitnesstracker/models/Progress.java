package org.example.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private Double weight;
    private Double bodyFatPercentage; // optional

    @ManyToOne
    private Users users;
}
