package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.types.EStatusTypes;
import java.util.List;

public interface ProjectTaskService {

    List<Project> findAllProjects();
    List<ProjectTask> findAll();
    List<ProjectTask> findByProjectId(String projectIdentifier);
    Double getProjectHours(String projectIdentifier);
    Double getProjectHoursByStatus(String projectIdentifier, EStatusTypes status);
    ProjectTask removeTask(Long taskId,String projectIdentifier);
    ProjectTask create(ProjectTask task);

}
