package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.taller.pds.tallerpds.types.EStatusTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ProjectTask")
public class ProjectTask extends EntityBase{

    @Column(name = "name")
    private String name;
    @Column(name = "summary")
    private String summary;
    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;
    @Column(name = "status")
    private EStatusTypes status;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "hours")
    private Double hours;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "project_identifier", updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
