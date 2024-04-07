package com.skoolio.IssueService.IssueService.repositories;

import com.skoolio.IssueService.IssueService.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueRepository
        extends MongoRepository<Issue,String>
{
}
