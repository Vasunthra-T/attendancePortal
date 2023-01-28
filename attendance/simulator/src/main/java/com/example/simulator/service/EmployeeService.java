package com.example.simulator.service;

import com.example.simulator.api.EmployeeInterface;
import com.example.simulator.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Object> showEmployee(){
        List<Object> employees = employeeRepository.getEmpCode();
       // List<Object> employees = employeeRepository.findAllEmpCode();


        //for(EmployeeRepository employee : employeeRepository)
        //List<String> employeeCodes = employeeRepository.findAll().get().getEmpCode();
        return employees;
   }


}
