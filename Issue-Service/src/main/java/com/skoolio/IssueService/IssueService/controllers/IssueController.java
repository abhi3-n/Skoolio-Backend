package com.skoolio.IssueService.IssueService.controllers;


import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.entities.IssueMessage;
import com.skoolio.IssueService.IssueService.services.IssueService;
import com.skoolio.IssueService.IssueService.model.IssueCloseRequest;
import com.skoolio.IssueService.IssueService.model.IssueMessageRequest;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "This endpoint is used to register a new issue.")
    public ResponseEntity<?> registerAnIssue(@RequestBody Issue issue){
        System.out.println(issue.toString());
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
    @Operation(summary = "This endpoint is used to add a new message to an existing issue.")
    public ResponseEntity<?> addIssueMessageToList(@RequestBody IssueMessageRequest issueMessageRequest){
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

    @PatchMapping("/closeIssue")
    @Operation(summary = "This endpoint is used to mark an issue as closed.")
    public ResponseEntity<?> closeIssue(@RequestBody IssueCloseRequest issueCloseRequest){
        try {
            issueService.closeIssue(issueCloseRequest.getIssueId());
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("status", "Issue closed");
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
