package com.example.timesheet.service;

import com.example.timesheet.api.TimesheetInterface;
import com.example.timesheet.model.Approval;
import com.example.timesheet.model.Hours;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Date;

@Service
public class TimesheetService implements TimesheetInterface {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    TimesheetRepository timesheetRepository;

    @Override
    public String addTimesheet(Timesheet timesheet, Approval approval){

        timesheetRepository.save(timesheet);
        return "Timesheet added successfully";
    }

    @Override
    public ResponseEntity<Double> calculateHours(String empCode, String workingDate){
        System.out.println("Line 37");
        System.out.println(empCode);
        System.out.println(workingDate);
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/simulate/calculateHours")
                .queryParam("empCode", empCode)
                .queryParam("workingDate", workingDate)
                .toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        System.out.println("Line 44");

        Hours totalHours = restTemplate().getForObject(url, Hours.class);
        System.out.println(totalHours);

        // double hours= restTemplate().getForObject(url, Double.class);
        System.out.println(totalHours.getHours());
        return new ResponseEntity<Double>(totalHours.getHours(),HttpStatus.OK);
    }
}
