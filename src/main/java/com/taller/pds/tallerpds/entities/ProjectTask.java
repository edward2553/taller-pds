package com.taller.pds.tallerpds.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.taller.pds.tallerpds.types.EStatusTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ProjectTask")
public class ProjectTask extends EntityBase{

    @Column(name = "name")
    @NotBlank(message = "El nombre no debe de estar en blanco")
    private String name;

    @Column(name = "summary")
    @NotBlank(message = "El resumen no debe de etar en blanco")
    private String summary;

    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EStatusTypes status;

    @Column(name = "priority")
    @Size(min = 1, max = 5, message = "la prioridad debe tener estar en un rango de 1 a 5")
    private Integer priority;

    @Column(name = "hours")
    @Min(value = 0L, message = "El valor debe de ser positivo")
    @Size(min = 1, max = 8, message = "Las horas deben de estar en un rango de 1 a 8 hrs")
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
