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

    @PutMapping("sequence/{id}")
    @ResponseBody
    public SequenceDefinition setSequence(@PathVariable("id") String id,@RequestBody HashMap<String,Object> map){

        System.out.println(map);
        SequenceDefinition sequenceDefinition = new SequenceDefinition();
        sequenceDefinition.setId(Long.parseLong(id));
        sequenceDefinition.setSequenceMenuName(map.get("sequenceMenuName").toString());
        sequenceDefinition.setDiagramText(map.get("sequenceText").toString());
        sequenceService.modifyMenu(sequenceDefinition);
        return sequenceService.getSequence(id);
    }

    @PostMapping("sequence")
    @ResponseBody
    public List<SequenceDefinition> createSequence(@RequestBody HashMap<String,Object> map){
        System.out.println(map);
        String sequenceMenuName = map.get("sequenceMenuName").toString();
        List<SequenceDefinition> sdList = sequenceService.createMenu(sequenceMenuName);
        return sdList;
    }
}
