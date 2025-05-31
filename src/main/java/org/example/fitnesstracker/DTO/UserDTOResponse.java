package org.example.fitnesstracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDTOResponse {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Double weight;
    private Double height;
    private LocalDate birthDate;
}
