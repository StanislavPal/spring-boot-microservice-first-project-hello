package com.springboot.microservice.first.project.service;

import com.springboot.microservice.first.project.dao.CounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
public class CounterService {

    @Autowired
    @Qualifier(value = "helloCounterDaoImpl")
    private CounterDao counterDao;

    @Transactional
    public BigInteger incrementCounter() {
        counterDao.incrementCounter();
        return counterDao.getCounter();
    }

    @Transactional
    public BigInteger getCounter() {
        return counterDao.getCounter();
    }
}
