package com.example.employee_management.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    @NotNull(message="O nome não pode estar vazio")
    private String firstName;
    @NotNull(message="O nome não pode estar vazio")
    private String email;
    @NotNull(message="O email n pode ser vazio")
    private String lastName;
}
