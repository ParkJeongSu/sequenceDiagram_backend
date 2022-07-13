package com.parkjeongsu.sequence.controller;

import com.parkjeongsu.sequence.domain.SequenceDefinition;
import com.parkjeongsu.sequence.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Controller
public class SequenceDefinitionController {

    @Autowired
    private SequenceService sequenceService;

    @GetMapping("sequences")
    @ResponseBody
    public List<SequenceDefinition> getSequence(){
        List<SequenceDefinition> sdList = sequenceService.getSequenceList();
        return sdList;
    }

    @GetMapping("sequence/{id}")
    @ResponseBody
    public SequenceDefinition getSequence(@PathVariable("id") String id){
        SequenceDefinition sequenceDefinition = sequenceService.getSequence(id);
        return sequenceDefinition;
    }

    @PutMapping("sequences")
    @ResponseBody
    public HashMap<String,Object> setSequence(@RequestBody HashMap<String,Object> map){

        //List<SequenceDefinition> sdList = sequenceService.modifyMenu();
        //map.put("objects",sdList);
        return map;
    }

    @PostMapping("sequences")
    @ResponseBody
    public HashMap<String,Object> createSequence(@RequestBody HashMap<String,Object> map){
        //HashMap<String,Object> map = new HashMap<>();
        List<SequenceDefinition> sdList = sequenceService.getSequenceList();
        map.put("objects",sdList);
        return map;
    }
}
