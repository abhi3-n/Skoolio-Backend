package com.Skoolio.StudentService.StudentSerivce.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MailService {
    public void sendStudentRegistrationMail(String email, String registrationId, String schoolId) throws JsonProcessingException;

}
