package com.springboot.microservice.first.project.dao;

import java.math.BigInteger;

public interface CounterDao {
    BigInteger getCounter();
    void incrementCounter();
}
