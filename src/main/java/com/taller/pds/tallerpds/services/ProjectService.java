package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project create(Project project);
}
