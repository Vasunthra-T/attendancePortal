package com.example.timesheet.api;

import com.example.timesheet.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface EmployeeInterface {
    //ResponseEntity<HashMap<String,String>> authUser(String email, String password);
    //Optional<Employee> getDetails(String empCode);

    ResponseEntity<Object> authUser(String email, String password);
}
