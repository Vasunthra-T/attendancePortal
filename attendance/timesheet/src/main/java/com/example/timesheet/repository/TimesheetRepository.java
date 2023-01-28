package com.example.timesheet.repository;

import com.example.timesheet.model.Employee;
import com.example.timesheet.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet,Integer> {
}
