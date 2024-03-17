package com.Skoolio.StudentService.StudentSerivce.implementation;

import com.Skoolio.StudentService.StudentSerivce.model.mailDetails.StudentRegistrationMail;
import com.Skoolio.StudentService.StudentSerivce.services.KafkaService;
import com.Skoolio.StudentService.StudentSerivce.services.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private KafkaService kafkaService;
    @Override
    public void sendStudentRegistrationMail(String email, String registrationId, String schoolId) throws JsonProcessingException {
        StudentRegistrationMail studentRegistrationMail = new StudentRegistrationMail();
        studentRegistrationMail.setUserMail(email);
        studentRegistrationMail.setApplicationID(registrationId);
        studentRegistrationMail.setSchoolId(schoolId);
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);
    }
}
