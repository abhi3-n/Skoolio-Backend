package com.skoolio.IssueService.IssueService.services;

import com.skoolio.IssueService.IssueService.entities.Issue;

import java.util.List;

public interface IssueService {

    String saveIssue(Issue issue);

    List<Issue> getIssuesForStudent(String studentId, Character status);
}
