package com.Skoolio.EmailService.EmailService.config;


import com.Skoolio.EmailService.EmailService.models.UserRegistrationMail;
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
    public void sendStudentRegistrationMail(UserRegistrationMail studentRegistrationMail){
        System.out.println("Email is - "+studentRegistrationMail.getUserMail());

        //First send mail to user.
        emailService.sendEmail(constants.getRegistrationSubject(),
                constants.getRegistrationBody1() + studentRegistrationMail.getApplicationID()+ constants.getRegistrationBody2(),
                studentRegistrationMail.getUserMail());

        //Then send mail to school
        //TODO:First fetch school name and school email from school service
        emailService.sendEmail(constants.getSchoolStudentRegistrationSubject(),
                constants.getSchoolStudentRegistrationBody1() +
                        studentRegistrationMail.getApplicationID() +
                        constants.getSchoolStudentRegistrationBody2(),
                "innocentheartplayschool@gmail.com");
    }

    //This function handles mail sending activities related to teacher registration.
    @KafkaListener(topics = "send-teacher-registration-mail",groupId = "group-1")
    public void sendTeacherRegistrationMail(UserRegistrationMail teacherRegistrationMail){
        System.out.println("Email is - "+teacherRegistrationMail.getUserMail());

        //First send mail to user.
        emailService.sendEmail(constants.getRegistrationSubject(),
                constants.getRegistrationBody1() + teacherRegistrationMail.getApplicationID()+ constants.getRegistrationBody2(),
                teacherRegistrationMail.getUserMail());

        //Then send mail to school
        //TODO:First fetch school name and school email from school service
        emailService.sendEmail(constants.getSchoolTeacherRegistrationSubject(),
                constants.getSchoolTeacherRegistrationBody1() +
                        teacherRegistrationMail.getApplicationID() +
                        constants.getSchoolTeacherRegistrationBody2(),
                "innocentheartplayschool@gmail.com");
    }
}
