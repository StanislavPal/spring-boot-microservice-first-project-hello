package com.springboot.microservice.first.project.controller;

import com.springboot.microservice.first.project.counter.CounterType;
import com.springboot.microservice.first.project.counter.dto.CounterDto;
import com.springboot.microservice.first.project.service.CounterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @MockBean
    private CounterService counterService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReturn200() throws Exception {
        CounterDto dto = new CounterDto(CounterType.HELLO, 34L);
        given(counterService.getCounter()).willReturn( dto.getCount() );
//                repository.getById(any())).willReturn(new Person(42, "Ivan"));
        mockMvc.perform(get("/hello/count"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].type", is( "HELLO" )));
    }
}
