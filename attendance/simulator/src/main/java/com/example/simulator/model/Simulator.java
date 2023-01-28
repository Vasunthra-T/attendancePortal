package com.example.simulator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Simulator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "emp_code")
    String empCode;


    //Timestamp timestamp = Timestamp.valueOf(localDateTime);

    @Column(name = "in_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date inTime;


    @Column(name = "out_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date outTime;


}



//    String dateTimePattern = "dd.MM.yyyy HH:mm z";
//
//    @Column(name = "in_time")
//    DateTimeFormatter inTime = DateTimeFormatter.ofPattern(dateTimePattern);
//
//
//    @Column(name = "out_time")
//    DateTimeFormatter outTime = DateTimeFormatter.ofPattern(dateTimePattern);


//}
