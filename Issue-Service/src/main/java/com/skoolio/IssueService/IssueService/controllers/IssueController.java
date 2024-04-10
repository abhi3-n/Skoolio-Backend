package com.skoolio.IssueService.IssueService.controllers;


import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.services.IssueService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @PostMapping
    public ResponseEntity<?> registerAnIssue(@RequestBody Issue issue){
        String issueId = issueService.saveIssue(issue);
        if(issueId!=null) {
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("issueId", issueId);
            return ResponseEntity.status(HttpStatus.SC_CREATED).body(hashMap);
        }
        else{
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
        }
    }



}
