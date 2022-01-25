package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTasks;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
