package com.taller.pds.tallerpds.services;

import com.taller.pds.tallerpds.entities.Backlog;

import java.util.List;

public interface BacklogService {

    List<Backlog> findAll();
    Backlog create(Backlog backlog);

}
