package com.project.login.Skoolio.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Backend {
    @GetMapping()
    public ResponseEntity<Response> createUser(){
        System.out.println("Request Recieved");
        Response response = new Response("Hello");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
