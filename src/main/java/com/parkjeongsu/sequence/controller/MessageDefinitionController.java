package com.parkjeongsu.sequence.controller;

import com.parkjeongsu.sequence.domain.MessageDefinition;
import com.parkjeongsu.sequence.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Controller
public class MessageDefinitionController {

    @Autowired
    private MessageService MessageService;

    @GetMapping("messages")
    @ResponseBody
    public List<MessageDefinition> getMessage(){
        List<MessageDefinition> sdList = MessageService.getMessageList();
        return sdList;
    }

    @GetMapping("message/{messageName}")
    @ResponseBody
    public MessageDefinition getMessage(@PathVariable("messageName") String messageName){
        MessageDefinition MessageDefinition = MessageService.getMessage(messageName);
        return MessageDefinition;
    }

    @PutMapping("message/{id}")
    @ResponseBody
    public MessageDefinition setMessage(@PathVariable("id") String id,@RequestBody HashMap<String,Object> map){

        System.out.println(map);
        MessageDefinition MessageDefinition = new MessageDefinition();

        String messageExampleContent = map.get("messageExampleContent") == null ? "" : map.get("messageExampleContent").toString();
        String messageDescription = map.get("messageDescription") == null ? "" : map.get("messageDescription").toString();

        MessageDefinition.setId(Long.parseLong(id));
        MessageDefinition.setExampleMessageContent(messageExampleContent);
        MessageDefinition.setMessageDescription(messageDescription);
        MessageService.modifyMessage(MessageDefinition);
        return MessageService.getMessageById(Long.parseLong(id));
    }

    @PostMapping("message")
    @ResponseBody
    public List<MessageDefinition> createMessage(@RequestBody HashMap<String,Object> map){
        System.out.println(map);
        String MessageMenuName = map.get("messageName").toString();
        List<MessageDefinition> sdList = MessageService.createMessage(MessageMenuName);
        return sdList;
    }
}
