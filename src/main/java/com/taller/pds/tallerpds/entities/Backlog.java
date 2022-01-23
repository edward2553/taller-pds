package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Backlog")
public class Backlog extends EntityBase {

    @Column(name = "project_identifier")
    private String projectIdentifier;

    @Column(name = "project")
    @JsonManagedReference
    @OneToOne(mappedBy = "backlog", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project")
    private Project project;

    @Column(name = "project_task")
    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "projectTask")
    private List<ProjectTask> projectTask;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
