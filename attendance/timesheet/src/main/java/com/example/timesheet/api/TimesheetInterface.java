package com.example.timesheet.api;

import com.example.timesheet.model.Approval;
import com.example.timesheet.model.Timesheet;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface TimesheetInterface {
    String addTimesheet(Timesheet timesheet, Approval approval);
    ResponseEntity<Double> calculateHours(String empCode, String workingDate);
}
