package com.example.simulator.model;

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
public class Hours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "emp_code")
    String empCode;


    @Column(name = "working_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    Date workingDate;


    @Column(name = "hours")
    double hours;

}
