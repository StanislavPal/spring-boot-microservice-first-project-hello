package com.springboot.microservice.first.project.counter.dto;

import com.springboot.microservice.first.project.counter.CounterType;

public class CounterDto {
    private CounterType type;
    private long count;

    public CounterDto(CounterType type, long count) {
        this.type = type;
        this.count = count;
    }

    public CounterType getType() {
        return type;
    }

    public void setType(CounterType type) {
        this.type = type;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
