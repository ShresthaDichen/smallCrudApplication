package com.smallproject.SmallCrudApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastname;
    @NotBlank(message = "Email cannot be blank")
            @Email(message = "email has to be special character")
    private String email;

}