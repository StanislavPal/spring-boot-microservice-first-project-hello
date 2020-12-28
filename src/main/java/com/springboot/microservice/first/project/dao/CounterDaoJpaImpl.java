package com.springboot.microservice.first.project.dao;

import com.springboot.microservice.first.project.counter.Counter;
import com.springboot.microservice.first.project.counter.CounterType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Primary
public class CounterDaoJpaImpl implements CounterDao{

    private final CounterType COUNTER_TYPE = CounterType.HELLO;

    @PersistenceContext
    private EntityManager em;

    @Override
    public long getCounter() {
        System.out.println("======= we are in jpa =======");
        String sql = "SELECT count(*) FROM counters WHERE type = :type";
        Query q = em.createNativeQuery(sql);
        q.setParameter("type", COUNTER_TYPE.ordinal() );
        return ( (Number) q.getSingleResult() ).longValue();
    }

    @Override
    public void incrementCounter() {
        em.persist( new Counter(COUNTER_TYPE) );
    }
}
