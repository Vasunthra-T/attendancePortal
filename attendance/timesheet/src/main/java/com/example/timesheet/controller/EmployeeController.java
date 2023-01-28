package com.example.timesheet.controller;

import com.example.timesheet.api.EmployeeInterface;
import com.example.timesheet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeInterface employeeInterface;

    @PostMapping("/authUser")
    public ResponseEntity<Object> authUser(@RequestParam String email, @RequestParam String password){
        return employeeInterface.authUser(email,password);
    }

//    @GetMapping("getEmpDetails/{empCode}")
//    public Optional<Employee> getDetails(@PathVariable String empCode){
//        return employeeInterface.getDetails(empCode);
//    }
}
