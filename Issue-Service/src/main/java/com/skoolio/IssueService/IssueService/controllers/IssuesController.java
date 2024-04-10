package com.skoolio.IssueService.IssueService.controllers;


import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.services.IssueService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssuesController {
    @Autowired
    private IssueService issueService;

    @GetMapping("/student/{studentId}/{status}")
    public ResponseEntity<?> getIssuesForStudent(@PathVariable String studentId, @PathVariable String status){
        System.out.println("getIssuesForStudent +" + status);
        try {
            List<Issue> issueList = issueService.getIssuesForStudent(studentId, status.charAt(0));
            if (!issueList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.SC_OK).body(issueList);
            } else {
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(null);
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
