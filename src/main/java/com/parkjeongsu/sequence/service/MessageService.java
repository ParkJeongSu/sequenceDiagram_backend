package com.parkjeongsu.sequence.service;

import com.parkjeongsu.sequence.domain.MessageDefinition;
import com.parkjeongsu.sequence.repository.JPAMessageDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private JPAMessageDefinitionRepository jpaMessageDefinitionRepository;

    public List<MessageDefinition> getMessageList(){
        return jpaMessageDefinitionRepository.readAll();
    }

    public List<MessageDefinition> createMessage(String messageName){
        MessageDefinition MessageDefinition = new MessageDefinition();
        MessageDefinition.setMessageName(messageName);
        jpaMessageDefinitionRepository.create(MessageDefinition);
        return jpaMessageDefinitionRepository.readAll();
    }

    public MessageDefinition modifyMessage(MessageDefinition MessageDefinition){
        return jpaMessageDefinitionRepository.putMessageDefinition(MessageDefinition);
    }
    public MessageDefinition getMessage(String messageName){
        return jpaMessageDefinitionRepository.getMessageDefinitionByMessageName(messageName);
    }
}
