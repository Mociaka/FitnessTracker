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
public class Goal {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean achieved;

    @ManyToOne
    private Users users;
}
