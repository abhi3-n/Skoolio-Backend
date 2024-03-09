package com.Skoolio.EmailService.EmailService.config;


import com.Skoolio.EmailService.EmailService.models.StudentRegistrationMail;
import com.Skoolio.EmailService.EmailService.services.EmailService;
import com.Skoolio.EmailService.EmailService.utils.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Autowired
    private EmailService emailService;
    @Autowired
    private Constants constants;

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder
                .name("send-student-registration-mail")
//                .partitions()
//                .replicas()
                .build();
    }

    //This function handles mail sending activities related to student registration.
    @KafkaListener(topics = "send-student-registration-mail",groupId = "group-1")
    public void sendStudentRegistrationMail(StudentRegistrationMail studentRegistrationMail){
        System.out.println("Email is - "+studentRegistrationMail.getStudentMail());
        //First send mail to user.
        emailService.sendEmail(constants.getStudentRegistrationSubject(),
                constants.getStudentRegistrationBody1() + studentRegistrationMail.getApplicationID()+ constants.getStudentRegistrationBody2(),
                studentRegistrationMail.getStudentMail());
        //Then send mail to school
        //TODO:First fetch school name and school email from school service
        emailService.sendEmail(constants.getSchoolStudentRegistrationSubject(),
                constants.getSchoolStudentRegistrationBody1() +
                        studentRegistrationMail.getApplicationID() +
                        constants.getSchoolStudentRegistrationBody2(),
                "innocentheartplayschool@gmail.com");
    }
}
