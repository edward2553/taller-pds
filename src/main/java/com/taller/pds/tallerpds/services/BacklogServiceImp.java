package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacklogServiceImp implements BacklogService{

    @Autowired
    private BacklogRepository repository;

    @Override
    public Backlog create(Backlog backlog) {
        return repository.save(backlog);
    }
}
