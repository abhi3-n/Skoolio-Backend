package com.skoolio.IssueService.IssueService.entities;

import com.skoolio.IssueService.IssueService.utils.UniqueIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("issue")
public class Issue implements Serializable {
    @Id
    private String issueId;
    private Long creationTime;
    private Character creatorType; //a student('s') or a teacher('t') can raise issues
    private String creatorId;
    private Integer schoolId;
    private String classId;
    private String title;
    private String description;
    private ArrayList<IssueMessage> issueMessages;
    private Character status; //open 'o', closed 'c'

    public void genId() {
        this.issueId = UniqueIdGenerator.generateUniqueId(this.creationTime.toString() + this.creatorId + this.creatorType.toString());
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId='" + issueId + '\'' +
                ", creationTime=" + creationTime +
                ", creatorType=" + creatorType +
                ", creatorId='" + creatorId + '\'' +
                ", schoolId=" + schoolId +
                ", classId='" + classId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", issueMessages=" + issueMessages.toString() +
                ", status=" + status +
                '}';
    }

    public void readyIssue() {
        this.setCreationTime(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        this.genId();
    }
    public void addIssueMessage(IssueMessage issueMessage) {
        if (this.issueMessages == null) {
            this.issueMessages = new ArrayList<>();
        }
        this.issueMessages.add(issueMessage);
    }

    public void closeIssue() {
        this.status = 'c';
    }
}
