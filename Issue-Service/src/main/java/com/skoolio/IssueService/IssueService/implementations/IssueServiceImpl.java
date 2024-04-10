package com.skoolio.IssueService.IssueService.implementations;

import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.repositories.IssueRepository;
import com.skoolio.IssueService.IssueService.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Override
    public String saveIssue(Issue issue) {
        issue.readyIssue();
        try {
            return issueRepository.save(issue).getIssueId();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Issue> getIssuesForStudent(String studentId, Character status) {
        return issueRepository.findByCreatorIdAndStatus(studentId, status);
    }
}
