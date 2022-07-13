package com.parkjeongsu.sequence.service;

import com.parkjeongsu.sequence.domain.SequenceDefinition;
import com.parkjeongsu.sequence.repository.JPASequenceDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SequenceService {

    @Autowired
    private JPASequenceDefinitionRepository jpaSequenceDefinitionRepository;

    public List<SequenceDefinition> getSequenceList(){
        return jpaSequenceDefinitionRepository.readAll();
    }

    public List<SequenceDefinition> createMenu(String sequenceName){
        SequenceDefinition sequenceDefinition = new SequenceDefinition();
        sequenceDefinition.setSequenceMenuName(sequenceName);
        jpaSequenceDefinitionRepository.create(sequenceDefinition);
        return jpaSequenceDefinitionRepository.readAll();
    }

    public SequenceDefinition modifyMenu(SequenceDefinition sequenceDefinition){
        return jpaSequenceDefinitionRepository.putSequenceDefinition(sequenceDefinition);
    }
    public SequenceDefinition getSequence(String id){
        return jpaSequenceDefinitionRepository.getSequenceDefinition(id);
    }
}
