package com.example.simulator.api;

import com.example.simulator.model.Simulator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface SimulatorInterface {
    String addSimulator( Simulator simulator);
    ResponseEntity<Double> calculateHours(String empCode, String workingDate);
}
