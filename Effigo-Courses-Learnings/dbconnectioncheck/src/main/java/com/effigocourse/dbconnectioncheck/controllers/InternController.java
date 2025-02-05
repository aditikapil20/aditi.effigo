package com.effigocourse.dbconnectioncheck.controllers;

import com.effigocourse.dbconnectioncheck.entity.InternEntity;
import com.effigocourse.dbconnectioncheck.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("intern-details/")
public class InternController {

    @Autowired
    private InternService internService;

    @PostMapping("/create-new-intern")
    public InternEntity createNewIntern(@RequestBody InternEntity internEntity)
    {
        return internService.createNewIntern(internEntity);
    }

}
