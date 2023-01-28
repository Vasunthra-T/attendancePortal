package com.example.simulator.service;

import com.example.simulator.api.SimulatorInterface;
import com.example.simulator.model.Hours;
import com.example.simulator.model.Simulator;
import com.example.simulator.repository.HoursRepository;
import com.example.simulator.repository.SimulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SimulatorService implements SimulatorInterface {
    @Autowired
    SimulatorRepository simulatorRepository;

    @Autowired
    HoursRepository hoursRepository;

    Hours entry =null;

    @Override
    public String addSimulator(Simulator simulator){
        simulatorRepository.save(simulator);
        return "Entry added to simulator successfully";
    }

    @Override
    public ResponseEntity<Double> calculateHours(String empCode, String workingDate)   {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);



        //String dateInString = "7-Jun-2013";
        Date parsedDate = null;
        try {
            //date = formatter.parse(workingDate);
             parsedDate = formatter.parse(workingDate);
            SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(print.format(parsedDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(empCode);
        System.out.println(workingDate);
        Optional<Simulator> opt = simulatorRepository.findByEmpCode(empCode);
        if (opt.isPresent()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date d1 = null;
            Date d2 = null;

            try {
                d1 = opt.get().getInTime();
                d2 = opt.get().getOutTime();
                System.out.println(d1);
                System.out.println(d2);

                //in milliseconds
                double diff = d2.getTime() - d1.getTime();

                double diffSeconds = diff / 1000 % 60;
                double diffMinutes = diff / (60 * 1000) % 60;
                double diffHours = diff / (60 * 60 * 1000) % 24;
                double diffDays = diff / (24 * 60 * 60 * 1000);

                // System.out.print(diffDays + " days, ");
                System.out.print(diffHours + " hours, ");
                //   System.out.print(diffMinutes + " minutes, ");
                //   System.out.print(diffSeconds + " seconds.");

                 entry = new Hours(1,empCode,parsedDate,diffHours);
                 hoursRepository.save(entry);
                System.out.println(entry.getHours());

                return new ResponseEntity<Double>(diffHours,HttpStatus.OK);

                //return diffHours;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return new ResponseEntity<Double>(401.0,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Double>(401.0,HttpStatus.NOT_FOUND);
    }

}
