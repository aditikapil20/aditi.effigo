package com.effigocourse.dbconnectioncheck.service;

import com.effigocourse.dbconnectioncheck.entity.InternEntity;
import com.effigocourse.dbconnectioncheck.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    @Autowired //to fetch the annotation and dependency injection
    private InternRepository internRepository;

    public InternEntity createNewIntern(InternEntity internEntity)
    {
        return internRepository.save(internEntity);
    }
}
