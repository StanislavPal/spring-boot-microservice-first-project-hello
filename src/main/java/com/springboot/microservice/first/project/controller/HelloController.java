package com.springboot.microservice.first.project.controller;

import com.springboot.microservice.first.project.counter.CounterType;
import com.springboot.microservice.first.project.counter.dto.CounterDto;
import com.springboot.microservice.first.project.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Environment environment;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private CounterService counterService;

    @GetMapping()
    public String sayHello() {
        counterService.incrementCounter();
        long counter = counterService.getCounter();
        kafkaSend("hello", "1", Long.toString(counter) );
        return "Добрый день! " + counter;
    }

    @GetMapping("/count")
    public ResponseEntity<CounterDto> getCount() {
        long counter = counterService.getCounter();
        CounterDto counterDto = new CounterDto(CounterType.HELLO, counter);
        counterDto.setPort( Integer.parseInt( environment.getProperty("local.server.port") ) );

        return new ResponseEntity<>(counterDto, HttpStatus.OK);
    }

    private void kafkaSend(String topic, String msgId, String counter) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msgId, counter);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
}
