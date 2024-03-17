package com.Skoolio.TeacherService.TeacherService.implementations;

import com.Skoolio.TeacherService.TeacherService.model.TeacherRegistrationMail;
import com.Skoolio.TeacherService.TeacherService.services.KafkaService;
import com.Skoolio.TeacherService.TeacherService.services.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private KafkaService kafkaService;
    @Override
    public void sendTeacherRegistrationMail(String email, String registrationId, Integer schoolId) throws JsonProcessingException {
        TeacherRegistrationMail studentRegistrationMail = new TeacherRegistrationMail();
        studentRegistrationMail.setUserMail(email);
        studentRegistrationMail.setApplicationID(registrationId);
        studentRegistrationMail.setSchoolId(schoolId);
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);
    }
}
