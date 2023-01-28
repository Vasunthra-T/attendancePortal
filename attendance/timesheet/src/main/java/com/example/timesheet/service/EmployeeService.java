package com.example.timesheet.service;

import com.example.timesheet.api.EmployeeInterface;
import com.example.timesheet.model.Employee;
import com.example.timesheet.repository.EmployeeRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeInterface {
    @Autowired
    EmployeeRepository employeeRepository;

//    @Override
//    public ResponseEntity<HashMap<String,String>> authUser(String email, String password) {
//        try {
//            HashMap<String, String> response = new HashMap<>();
//            Optional<Employee> opt = employeeRepository.findByEmailAndPassword(email, password);
//
//            if (opt.isPresent()) {
//                response.put("role", opt.get().getRole());
//                response.put("empCode", opt.get().getEmpCode());
//
//                return new ResponseEntity<HashMap<String, String>>(response,HttpStatus.OK);
//            } else {
//                response.put("message","Username or password is incorrect");
//                return new ResponseEntity<HashMap<String, String>>(response,HttpStatus.UNAUTHORIZED);
//            }
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.MULTI_STATUS);
//        }
//    }

    @Override
    public ResponseEntity<Object> authUser(String email, String password) {
        try {
          //  HashMap<String, Optional<Employee>> response = new HashMap<>();
            Optional<Employee> opt = employeeRepository.findByEmailAndPassword(email, password);
            opt.get().setPassword("****");

            if (opt.isPresent()) {
              //  response.put("Employee details",opt);
              //  response.put("empCode", opt.get().getEmpCode());

                return new ResponseEntity<Object>(opt,HttpStatus.OK);
            } else {
               // response.put("Username or password is incorrect",Optional.empty());
                String message ="Username or password is incorrect";
                return new ResponseEntity<Object>(message,HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            String message ="Username or password is incorrect";
            return new ResponseEntity<Object>(message,HttpStatus.UNAUTHORIZED);
            //throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }




//    @Override
//    public Optional<Employee> getDetails(String empCode){
//        Optional<Employee> opt = employeeRepository.findByEmpCode(empCode);
//        opt.get().setPassword("****");
//        if(opt.isPresent())
//            return opt;
//        else
//            return Optional.empty();
//
//    }
}
