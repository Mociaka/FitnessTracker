package org.example.fitnesstracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExerciseDTOResponse {
    private Long id;
    private String name;
    private Integer sets;
    private Integer reps;
    private Double weight;
    private Long workoutId;
}
