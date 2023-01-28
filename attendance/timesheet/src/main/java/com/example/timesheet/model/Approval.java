package com.example.timesheet.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Approval implements Serializable {
    public enum Period {
        FIRST_HALF, SECOND_HALF ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "timesheet_id")
    Integer timesheetId;

    @Column(name = "manager_id")
    String managerId;

    @Column(name = "day_count")
    double dayCount;

    @Column(name = "period")
    @Enumerated(EnumType.STRING)
    Period period;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @Column(name = "status")
    String status;

}
