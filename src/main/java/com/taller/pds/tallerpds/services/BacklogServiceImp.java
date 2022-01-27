package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.exceptions.BadRequestException;
import com.taller.pds.tallerpds.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImp implements BacklogService{

    @Autowired
    private BacklogRepository repository;

    @Override
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    public Backlog create(Backlog backlog) {
        if (backlog.getProjectIdentifier() == "" || backlog.getProjectIdentifier() == null) {
            throw new  BadRequestException();
        }
        return repository.save(backlog);}
}
