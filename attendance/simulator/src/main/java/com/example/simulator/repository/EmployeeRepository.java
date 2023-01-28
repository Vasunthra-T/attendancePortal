package com.example.simulator.repository;

import com.example.simulator.model.Employee;
import com.example.simulator.model.Simulator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select emp_code from Employee",nativeQuery = true)
    List<Object> getEmpCode();

   // List<Object> findAllEmpCode();

}
