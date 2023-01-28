package com.example.simulator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    int id;
    String empName;
    String empCode;
    long phone;
    String email;
    String managerId;
    String role;
    String password;
}
