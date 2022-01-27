package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.exceptions.BadRequestException;
import com.taller.pds.tallerpds.exceptions.NotFoundException;
import com.taller.pds.tallerpds.repository.ProjectRepository;
import com.taller.pds.tallerpds.repository.ProjectTaskRepository;
import com.taller.pds.tallerpds.types.EStatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTaskServiceImp implements ProjectTaskService {

    @Autowired
    private ProjectTaskRepository repository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<ProjectTask> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProjectTask> findByProjectId(String projectIdentifier) {
        List<Project> aTemp = findAllProjects();
        for (int i = 0; i < aTemp.size(); i++) {
            if(aTemp.get(i).getProjectIdentifier().equals(projectIdentifier)){
                return aTemp.get(i).getBacklog().getProjectTasks();
            }
        }
        throw new NotFoundException();
    }

    @Override
    public Double getProjectHours(String projectIdentifier) {
        double hours = 0;
        List<ProjectTask> aTemp = findByProjectId(projectIdentifier);
        for (int i = 0; i < aTemp.size(); i++) {
            if(!aTemp.get(i).getStatus().equals("DELETED")) {
                hours += aTemp.get(i).getHours();
            }

        }
        return hours;
    }

    @Override
    public Double getProjectHoursByStatus(String projectIdentifier, EStatusTypes status) {
        double horas=0;
        List<ProjectTask> p= findByProjectId(projectIdentifier);
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getStatus().toString().equals(status)) {
                horas += p.get(i).getHours();
            }
        }
        return horas;
    }

    @Override
    public ProjectTask removeTask(Long taskId, String projectIdentifier){

        List<ProjectTask> aTemp = findByProjectId(projectIdentifier);
        for (int i = 0; i < aTemp.size(); i++) {
            if (aTemp.get(i).getId() == taskId){
                aTemp.get(i).setStatus(EStatusTypes.DELETED);
                repository.delete(aTemp.get(i));
                return aTemp.get(i);
            }

        }
        throw new NotFoundException();
    }

    @Override
    public ProjectTask create(ProjectTask task) {
        if (task.getName() == "" || task.getName() == null) {
            throw new BadRequestException();
        }
        if (task.getSummary() == "" || task.getSummary() == null) {
            throw new BadRequestException();
        }
        if (task.getPriority() < 1 || task.getPriority() > 5) {
            throw new BadRequestException();
        }
        if (task.getHours() < 1 || task.getHours() > 8) {
            throw new BadRequestException();
        }
        return repository.save(task);
    }
}
