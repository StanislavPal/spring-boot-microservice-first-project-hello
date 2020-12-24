package com.springboot.microservice.first.project.service;

import com.springboot.microservice.first.project.dao.CounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    @Autowired
    private CounterDao counterDao;

    public long incrementCounter() {
        counterDao.setCounter( counterDao.getCounter() + 1L );
        return counterDao.getCounter();
    }

    public long getCounter() {
        return counterDao.getCounter();
    }
}
