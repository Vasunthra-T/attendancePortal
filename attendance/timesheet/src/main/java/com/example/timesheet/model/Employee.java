package com.example.timesheet.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    @Id
    Integer id;
    String empName;
    String empCode;
    long phone;
    String email;
    String managerId;
    String role;
    String password;
}
