package com.example.hellospringboot;

import com.example.hellospringboot.dto.ObjectMapperUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringBootApplicationTests {

    @Test
     void contextLoads() throws JsonProcessingException {
        System.out.println("hello");

        // <object mapper의 역할>
        // 1) Object를 Text 형태의 Json으로 바꿔준다.
        // 2) Text형태의 Json을 Object로 바꿔준다.

        var objectMapper = new ObjectMapper();

        // 1) object -> text
        // : 이때는 objectMapper가 get method를 활용한다.
        // +) get/set method가 아닌 method를 추가할 때, method 이름이 get으로 시작하면 안된다.
        var user = new ObjectMapperUser("steve",20,"010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // 2) text -> object
        // : 이때는 objectMapper가 기본 생성자를 사용한다.
        var objectUser = objectMapper.readValue(text, ObjectMapperUser.class);
        System.out.println(objectUser);
    }
}
