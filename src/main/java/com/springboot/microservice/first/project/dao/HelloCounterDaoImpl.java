package com.springboot.microservice.first.project.dao;

import com.springboot.microservice.first.project.counter.Counter;
import com.springboot.microservice.first.project.counter.CounterType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

@Repository
public class HelloCounterDaoImpl implements CounterDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public BigInteger getCounter() {
        Query q = em.createNativeQuery("SELECT count(*) FROM counters WHERE type = :type");
        q.setParameter("type", CounterType.hello.ordinal() );
        return (BigInteger) q.getSingleResult();
    }

    @Override
    public void incrementCounter() {
        em.persist( new Counter(CounterType.hello) );
    }
}
