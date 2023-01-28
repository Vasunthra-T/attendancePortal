package com.example.simulator.controller;

import com.example.simulator.api.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeInterface employeeInterface;


    @GetMapping("showEmployee")
    public List<Object> showEmployee(){
        return employeeInterface.showEmployee();
    }
}
