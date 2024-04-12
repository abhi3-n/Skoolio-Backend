package com.skoolio.IssueService.IssueService.implementations;

import com.skoolio.IssueService.IssueService.entities.Issue;
import com.skoolio.IssueService.IssueService.entities.IssueMessage;
import com.skoolio.IssueService.IssueService.repositories.IssueRepository;
import com.skoolio.IssueService.IssueService.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Issue> getIssuesForAdmin(Integer schoolId, Character status) {
        return issueRepository.findBySchoolIdAndStatus(schoolId, status);
    }

    @Override
    public List<Issue> getIssuesForTeacher(String classId, Character status) {
        return issueRepository.findByClassIdAndStatus(classId, status);
    }

    @Override
    public void addIssueMessageToList(IssueMessage issueMessage, String issueId) {
        Optional<Issue> existingIssue = issueRepository.findById(issueId);
        if (existingIssue.isPresent()) {
            Issue issueToUpdate = existingIssue.get();
            issueToUpdate.addIssueMessage(issueMessage);
            issueRepository.save(issueToUpdate);
        }
        else{
            //TODO:Throw exception from here
            System.out.println("Issue with id: " + issueId + " not found");
        }
    }

    @Override
    public void closeIssue(String issueId) {
        Optional<Issue> existingIssue = issueRepository.findById(issueId);
        if (existingIssue.isPresent()) {
            Issue issueToUpdate = existingIssue.get();
            issueToUpdate.closeIssue();
            issueRepository.save(issueToUpdate);
        }
        else{
            //TODO:Throw exception from here
            System.out.println("Issue with id: " + issueId + " not found");
        }
    }
}
