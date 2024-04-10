package com.skoolio.IssueService.IssueService.repositories;

import com.skoolio.IssueService.IssueService.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IssueRepository
        extends MongoRepository<Issue,String>
{
//    List<Issue> findByCreatorId(String creatorId);
    List<Issue> findByCreatorIdAndStatus(String creatorId, char status);
}
