package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.types.EStatusTypes;
import java.util.List;

public interface ProjectTaskService {

    List<ProjectTask> findAll();
    List<ProjectTask> findByProjectId(String projectIdentifier);
    Integer getProjectHours(String projectIdentifier);
    Integer getProjectHoursByStatus(String projectIdentifier, EStatusTypes status);
    void removeTask(Long taskId,String projectIdentifier);
    ProjectTask create(ProjectTask task);

}
