package com.example.simulator.controller;

import com.example.simulator.api.SimulatorInterface;
import com.example.simulator.model.Simulator;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/simulate")
public class SimulatorController {
    @Autowired
    SimulatorInterface simulatorInterface;

    @PostMapping("addSimulator")
    public String addSimulator(@RequestBody Simulator simulator){
        return  simulatorInterface.addSimulator(simulator);
    }

    @GetMapping("calculateHours")
    public ResponseEntity<Double> calculateHours(@RequestParam String empCode, @RequestParam String workingDate )
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String workingDate )
    {

        System.out.println(workingDate.getClass());
        return simulatorInterface.calculateHours(empCode,workingDate);
    }
}
