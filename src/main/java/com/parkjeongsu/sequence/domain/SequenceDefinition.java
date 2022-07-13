package com.parkjeongsu.sequence.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="SEQUENCEDEFINITION")
public class SequenceDefinition implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="SEQUENCEMENUNAME")
    private String sequenceMenuName;

    @Column(name="DIAGRAMTEXT")
    private String diagramText;

    public SequenceDefinition() {
    }

    public SequenceDefinition(Long id, String sequenceMenuName, String diagramText) {
        this.id = id;
        this.sequenceMenuName = sequenceMenuName;
        this.diagramText = diagramText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequenceMenuName() {
        return sequenceMenuName;
    }

    public void setSequenceMenuName(String sequenceMenuName) {
        this.sequenceMenuName = sequenceMenuName;
    }

    public String getDiagramText() {
        return diagramText;
    }

    public void setDiagramText(String diagramText) {
        this.diagramText = diagramText;
    }
}
