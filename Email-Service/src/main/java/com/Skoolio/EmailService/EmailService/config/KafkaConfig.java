package com.Skoolio.EmailService.EmailService.config;


import com.Skoolio.EmailService.EmailService.models.TempClass;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder
                .name("send-email")
//                .partitions()
//                .replicas()
                .build();
    }



    @KafkaListener(topics = "send-mail",groupId = "group-1")
//    public void sendEmail(String emailId){
    public void sendEmail(TempClass tempClass){
        System.out.println("Email is - "+tempClass.getSubject());
    }
}
