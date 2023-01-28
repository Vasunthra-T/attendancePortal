package com.example.timesheet.controller;

import com.example.timesheet.api.TimesheetInterface;
import com.example.timesheet.model.Approval;
import com.example.timesheet.model.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/time")
public class TimesheetController {

    @Autowired
    TimesheetInterface timesheetInterface;

    @PostMapping("addTimesheet")
    public String addTimesheet(@RequestBody Timesheet timesheet, @RequestBody Approval approval){
        return timesheetInterface.addTimesheet(timesheet,approval);
    }

    @GetMapping("calculateHours")
    public ResponseEntity<Double> calculateHours(@RequestParam String empCode, @RequestParam String workingDate)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date workingDate )
    {
        System.out.println(workingDate.getClass());
        return timesheetInterface.calculateHours(empCode,workingDate);
    }
}
