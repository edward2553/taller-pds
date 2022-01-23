package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.repository.ProjectTaskRepository;
import com.taller.pds.tallerpds.types.EStatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskServiceImp implements ProjectTaskService{

    @Autowired
    private ProjectTaskRepository repository;

    @Override
    public List<ProjectTask> findByProjectId(String projectIdentifier) {
        return repository.findByProjectId(projectIdentifier);
    }

    @Override
    public Integer getProjectHours(String projectId) {
        return repository.getProjectHours(projectId);
    }

    @Override
    public Integer getProjectHoursByStatus(String projectId, EStatusTypes status) {
        return repository.getProjectHoursByStatus(projectId, status);
    }

    @Override
    public void removeTask(Long taskId, String projectId) {
        repository.removeTask(taskId, projectId);
    }

    @Override
    public ProjectTask create(ProjectTask task) {
        return repository.save(task);
    }
}
