package com.Skoolio.TeacherService.TeacherService.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MailService {
    public void sendTeacherRegistrationMail(String email, String registrationId, Integer schoolId) throws JsonProcessingException;
}
