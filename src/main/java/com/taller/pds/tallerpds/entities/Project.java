package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Project")
public class Project extends EntityBase {

    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_identifier")
    private String projectIdentifier;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "backlog")
    @JsonBackReference
    @OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "backlog")
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
