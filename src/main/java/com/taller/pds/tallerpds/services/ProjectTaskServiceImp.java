package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.repository.ProjectTaskRepository;
import com.taller.pds.tallerpds.types.EStatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTaskServiceImp implements ProjectTaskService{

    @Autowired
    private ProjectTaskRepository repository;

    @Override
    public List<ProjectTask> findByProjectId(String projectIdentifier) {
        List<ProjectTask> aTemp = new ArrayList<>();
        return aTemp;
    }

    @Override
    public Integer getProjectHours(String projectIdentifier) {
        return 1;
    }

    @Override
    public Integer getProjectHoursByStatus(String projectIdentifier, EStatusTypes status) {
        return 1;
    }

    @Override
    public void removeTask(Long taskId, String projectIdentifier){
        assert true;
    }

    @Override
    public ProjectTask create(ProjectTask task) {
        return repository.save(task);
    }
}
