package com.skoolio.IssueService.IssueService.repositories;

import com.skoolio.IssueService.IssueService.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IssueRepository
        extends MongoRepository<Issue,String>
{
//    List<Issue> findByCreatorId(String creatorId);
    List<Issue> findByCreatorIdAndStatus(String creatorId, char status);
    List<Issue> findBySchoolIdAndStatus(Integer schoolId, char status);
    List<Issue> findByClassIdAndStatus(String classId, char status);

    Issue findByIssueId(String issueId);
}
