package com.skoolio.IssueService.IssueService.controllers;


import com.skoolio.IssueService.IssueService.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;
}
