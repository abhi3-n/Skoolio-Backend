package com.Skoolio.StudentService.StudentSerivce.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class TempClass implements Serializable {
    private String to;
    private String subject;
    private String body;
}
