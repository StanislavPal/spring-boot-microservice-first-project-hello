package com.springboot.microservice.first.project.dao;

import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class CounterDaoInMemoryImpl implements CounterDao {

    private BigInteger counter;

    @Override
    public BigInteger getCounter() {
        return counter;
    }

    @Override
    public void incrementCounter() {
        this.counter.add(BigInteger.ONE);
    }

}
