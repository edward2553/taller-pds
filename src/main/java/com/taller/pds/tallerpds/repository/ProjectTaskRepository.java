package com.taller.pds.tallerpds.repository;

import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.types.EStatusTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

}
