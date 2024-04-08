package com.skoolio.IssueService.IssueService.entities;

import com.skoolio.IssueService.IssueService.utils.UniqueIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("issue")
public class Issue {
    private String issueId;
    private Long creationTime;
    private Character creatorType; //a student('s') or a teacher('t') can raise issues
    private String creatorId;
    private String title;
    private String description;
    private IssueMessage[] issueMessages;
    private Character status; //open 'o', closed 'c'

    public void genId() {
        this.issueId = UniqueIdGenerator.generateUniqueId(this.creationTime.toString() + this.creatorId + this.creatorType.toString());
    }

    public void readyIssue() {
        this.setCreationTime(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        this.genId();
    }
}
