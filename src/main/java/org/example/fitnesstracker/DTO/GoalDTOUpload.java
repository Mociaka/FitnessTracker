package org.example.fitnesstracker.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GoalDTOUpload {
    private String title;
    private String description;
    private LocalDate targetDate;
}
