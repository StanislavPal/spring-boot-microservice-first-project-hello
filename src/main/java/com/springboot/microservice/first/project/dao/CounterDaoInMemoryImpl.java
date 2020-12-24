package com.springboot.microservice.first.project.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoInMemoryImpl implements CounterDao {

    private long counter;

    @Override
    public long getCounter() {
        return counter;
    }

    @Override
    public void setCounter(long counter) {
        this.counter = counter;
    }

}
