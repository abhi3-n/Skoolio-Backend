package com.Skoolio.StudentService.StudentSerivce.services;
import com.Skoolio.StudentService.StudentSerivce.model.TempClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean sendEmail(TempClass tempClass) throws JsonProcessingException {
        System.out.println("Email Id is -"+ tempClass.getBody());
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the object to JSON
        String json = objectMapper.writeValueAsString(tempClass);

        kafkaTemplate.send("send-mail",json);
        return true;
    }
}