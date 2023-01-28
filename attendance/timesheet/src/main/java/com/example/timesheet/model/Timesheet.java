package com.example.timesheet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Timesheet implements Serializable {
    public enum InType {
        WORK_FROM_HOME, OFFICE, BOTH ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "emp_name")
    String empName;

    @Column(name = "emp_code")
    String empCode;

    @Column(name = "working_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    Date workingDate;

    @Column(name = "hours")
    double hours;

    @Column(name = "in_type")
    @Enumerated(EnumType.STRING)
    InType inType;

}
