package com.example.simulator.kafka;

import com.example.simulator.model.Employee;
import com.example.simulator.service.SimulatorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListenerService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SimulatorService simulatorService;

    @KafkaListener(topics = "send.employee",groupId = "finance")
    public void getInvoiceForBilling(ConsumerRecord<?,String> consumerRecord){
        Employee employee = null;
        try {
            System.out.println("\n\tEntered kafka listener!!!!!!!!!!!!!!!");
            employee = objectMapper.readValue(consumerRecord.value(),
                    new TypeReference<Employee>() {
                    });

            System.out.println("\n\t--------->Entered<----------");
            System.out.println(simulatorService.getClass());
          //  simulatorService.enterPaymentInfo(payment);
        }catch (Exception e){

        }

    }
}
