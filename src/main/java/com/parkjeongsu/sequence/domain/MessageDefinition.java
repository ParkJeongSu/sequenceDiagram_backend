package com.parkjeongsu.sequence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="MESSAGEDEFINITION")
public class MessageDefinition implements Serializable {
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="MESSAGENAME")
    private String messageName;

    @Column(name="EXAMPLEMESSAGECONTENT")
    private String exampleMessageContent;

    @Column(name="MESSAGEDESCRIPTION")
    private String messageDescription;

    public MessageDefinition() {
    }

    public MessageDefinition(Long id, String messageName, String exampleMessageContent, String messageDescription) {
        this.id = id;
        this.messageName = messageName;
        this.exampleMessageContent = exampleMessageContent;
        this.messageDescription = messageDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getExampleMessageContent() {
        return exampleMessageContent;
    }

    public void setExampleMessageContent(String exampleMessageContent) {
        this.exampleMessageContent = exampleMessageContent;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }
}
