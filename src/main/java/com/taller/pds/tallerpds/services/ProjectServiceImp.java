package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{

    @Autowired
    private ProjectRepository repository;

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project create(Project project) {
        return repository.save(project);
    }
}
