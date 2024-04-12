package com.skoolio.IssueService.IssueService.services;

import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.entities.IssueMessage;

import java.util.List;

public interface IssueService {

    String saveIssue(Issue issue);

    List<Issue> getIssuesForStudent(String studentId, Character status);

    void addIssueMessageToList(IssueMessage issueMessage, String issueId);

    void closeIssue(String issueId);

    List<Issue> getIssuesForAdmin(Integer schoolId, Character status);

    List<Issue> getIssuesForTeacher(String classId, Character status);
}
