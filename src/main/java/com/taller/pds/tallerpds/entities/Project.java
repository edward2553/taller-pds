package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Project")
public class Project extends EntityBase {

    @NotNull
    @Column(name = "project_name", unique = true)
    @NotBlank(message = "El nombre del proyecto no debe de estar en blanco")
    private String projectName;

    @NotNull
    @Column(name = "project_identifier", unique = true, updatable = false)
    @NotBlank(message = "El identificador del proyecto no debe de estar en blanco")
    @Size(min = 5, max = 7, message = "El identificador del proyecto debe tener minimo 5 y máximo 7 caracteres")
    private String projectIdentifier;

    @Column(name = "description")
    @NotBlank(message = "La descripción del proyecto no debe de estar en blanco")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    private String uri;

    @JsonManagedReference
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
