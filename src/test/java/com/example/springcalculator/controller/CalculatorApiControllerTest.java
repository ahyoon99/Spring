package com.example.springcalculator.controller;

import com.example.springcalculator.component.Calculator;
import com.example.springcalculator.component.DollarCalculator;
import com.example.springcalculator.component.MarketApi;
import com.example.springcalculator.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApiController.class)  // CalculatorApiController.class만 테스트 해준다. 필요한 것만 로딩하기 때문에 자원을 조금 더 줄일 수 있다.
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;    // Mvc를 Mocking으로 테스트하겠다는 것이다.

    @BeforeEach
    public void init(){
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        // sum의 주소는 http://localhost:8080/api/sum 이다.
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                        .queryParam("x","10")
                        .queryParam("y", "10")
        ).andExpect(    // 아래와 같은 값을 기대한다.
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());  // 내용 출력하기
    }

    @Test
    public void minusTest() throws Exception {
        // 우리가 request를 하나 보내야 하기 때문에 request 객체를 하나 만든다.
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);   // req가 자동으로 json으로 바뀐다.

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                // 내가 기대하는 result의 value값은 0이다.
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                // 내가 기대하는 response안에 있는 resultCode의 value값은 OK이다.
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
                ).andDo(MockMvcResultHandlers.print());
    }

}
