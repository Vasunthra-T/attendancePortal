package com.example.timesheet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hours {
    int id;
    String emp_code;
    Date workingDate;
    double hours;
}
