package com.Skoolio.TeacherService.TeacherService.services;

import com.Skoolio.TeacherService.TeacherService.model.TeacherRegistrationMail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public boolean sendStudentRegistrationMail(TeacherRegistrationMail teacherRegistrationMail) throws JsonProcessingException {
        System.out.println("Email Id is -"+ teacherRegistrationMail.getUserMail());
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the object to JSON
        String mailContent = objectMapper.writeValueAsString(teacherRegistrationMail);

        kafkaTemplate.send("send-teacher-registration-mail",mailContent);
        return true;
    }
}
