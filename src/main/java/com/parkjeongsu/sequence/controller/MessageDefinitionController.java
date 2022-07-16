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
        MessageDefinition.setId(Long.parseLong(id));
        MessageDefinition.setExampleMessageContent(map.get("messageExampleContent").toString());
        MessageDefinition.setMessageDescription(map.get("messageDescription").toString());
        MessageService.modifyMessage(MessageDefinition);
        return MessageService.getMessage(id);
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
