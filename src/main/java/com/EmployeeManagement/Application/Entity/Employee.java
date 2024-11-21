package com.EmployeeManagement.Application.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Employee ID cannot be null")
    private Long Id;

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 20, message = "FirstName should be between 3 and 10 characters")
    private String userFirstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max =20, message = "LastName should be between 3 and 10 characters")
    private String userLastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Location is required")
    private String location;



}
