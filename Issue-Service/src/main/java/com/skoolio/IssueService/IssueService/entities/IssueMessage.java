package com.skoolio.IssueService.IssueService.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("issue_message")
public class IssueMessage implements Serializable {
    private String messageCreatorId;
    private Character messageCreatorType;
    private String messageText;
    private Long messageTime ;
    @Override
    public String toString() {
        return "IssueMessage{" +
                "messageCreatorId='" + messageCreatorId + '\'' +
                ", messageCreatorType=" + messageCreatorType +
                ", messageText='" + messageText + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }

    // Custom serialization logic
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // Write fields to the ObjectOutputStream
        out.writeObject(messageCreatorId);
        out.writeObject(messageCreatorType);
        out.writeObject(messageText);
        out.writeObject(messageTime);
    }

    // Custom deserialization logic
    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Read fields from the ObjectInputStream
        messageCreatorId = (String) in.readObject();
        messageCreatorType = (Character) in.readObject();
        messageText = (String) in.readObject();
        messageTime = (Long) in.readObject();
    }
}


