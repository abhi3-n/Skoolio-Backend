package com.Skoolio.StudentService.StudentSerivce.services;
import com.Skoolio.StudentService.StudentSerivce.model.StudentRegistrationMail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public boolean sendStudentRegistrationMail(StudentRegistrationMail studentRegistrationMail) throws JsonProcessingException {
        System.out.println("Email Id is -"+ studentRegistrationMail.getUserMail());
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the object to JSON
        String mailContent = objectMapper.writeValueAsString(studentRegistrationMail);

        kafkaTemplate.send("send-student-registration-mail",mailContent);
        return true;
    }
}