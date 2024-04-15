package com.skoolio.IssueService.IssueService.model;

import com.skoolio.IssueService.IssueService.entities.IssueMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IssueMessageRequest {
    private String messageCreatorId;
    private Character messageCreatorType;
    private String messageText;
    private Long messageTime ;
    private String issueId;
}
