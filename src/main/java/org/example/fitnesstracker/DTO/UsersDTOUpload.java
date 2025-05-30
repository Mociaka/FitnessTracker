package org.example.fitnesstracker.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UsersDTOUpload {
    private String username;
    private String email;
    private String password;
    private Double weight;
    private Double height;
    private LocalDate birthDate;

}
