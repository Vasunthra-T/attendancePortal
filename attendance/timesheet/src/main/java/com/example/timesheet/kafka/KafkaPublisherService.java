package com.example.timesheet.kafka;

import com.example.timesheet.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendWholesalerForBilling(Employee employee){
        try{
            kafkaTemplate.send("send.employee", this.objectMapper.writeValueAsString(employee));
            System.out.println("\n\t sent kafka message!!!!!!!!!!!!!!!");
        }catch(Exception e){
            System.out.println("Error is building "+ e);
        }
    }

}
