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
    @NotEmpty(message="O nome não pode estar vazio")
    @Size(min=2,max=30,message="O nome deve ter entre 2 e 30 caracteres")
    private String firstName;
    @Email(message = "Forneça um email válido")
    private String email;
    @NotEmpty(message="O email n pode ser vazio")
    private String lastName;
}
