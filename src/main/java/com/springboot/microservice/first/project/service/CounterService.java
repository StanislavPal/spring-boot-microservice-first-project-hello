package com.springboot.microservice.first.project.service;

import com.springboot.microservice.first.project.dao.CounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    @Autowired
    private CounterDao counterDao;

    @Transactional
    public void incrementCounter() {
        counterDao.incrementCounter();
    }

    @Transactional
    public long getCounter() {
        return counterDao.getCounter();
    }
}
