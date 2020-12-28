package com.springboot.microservice.first.project.counter.dto;

import com.springboot.microservice.first.project.counter.CounterType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//todo делал по этой статье
// https://otus.ru/nest/post/428/?utm_source=partners&utm_medium=cpa&utm_campaign=otus&utm_term=admitad&admitad_uid=07212003c1125baba252b76501f33948
@JsonTest
class CounterDtoTest {
    @Autowired
    private JacksonTester<CounterDto> json;

    @Test
    void testSerializeCounterDto() throws Exception {
        CounterDto dto = new CounterDto( CounterType.HELLO, 34L);
        assertThat(this.json.write(dto))
//                .isStrictlyEqualToJson("simple-counter-dto.json"); //todo как это сделать через файл .json как в статье?
                .isStrictlyEqualToJson("{\"type\":\"HELLO\",\"count\":34}");
    }

    @Test
    void testDeserializeCounterDto() throws Exception {
        CounterDto dto = this.json.read("simple-counter-dto.json").getObject(); //todo как это сделать через файл .json как в статье?
//        CounterDto dto = this.json.read("{\"type\":\"HELLO\",\"count\":34}").getObject();
        assertEquals(CounterType.HELLO, dto.getType());
        assertEquals(34L, dto.getCount());
    }

}