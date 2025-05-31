package org.example.fitnesstracker.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NutritionLogDTOUpload {
    private LocalDate date;
    private Integer calories;
    private Integer protein;
    private Integer carbs;
    private Integer fat;
    private String notes;
}
