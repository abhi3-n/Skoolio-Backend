package com.skoolio.IssueService.IssueService.controllers;


import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.entities.IssueMessage;
import com.skoolio.IssueService.IssueService.services.IssueService;
import model.IssueMessageRequest;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/addMessage")
    public ResponseEntity<?> addIssueMessageToList(@RequestBody IssueMessageRequest issueMessageRequest){
        System.out.println("In controller -\n "+issueMessageRequest.getMessageCreatorId());
        try {
            issueService.addIssueMessageToList(new IssueMessage(issueMessageRequest.getMessageCreatorId(), issueMessageRequest.getMessageCreatorType(), issueMessageRequest.getMessageText(), issueMessageRequest.getMessageTime()), issueMessageRequest.getIssueId());
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("status", "Message added");
            return ResponseEntity.status(HttpStatus.SC_OK).body(hashMap);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("status", "Some Error occured");
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(hashMap);
        }
    }
}
