package com.exemple.probe.controllersTest;

import com.example.probe.ProbeApplication;
import com.example.probe.controller.PizzaController;
import com.example.probe.entity.Pizza;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProbeApplication.class)
@AutoConfigureMockMvc
public class PizzaTest {
@Autowired
    private MockMvc mockMvc;
@Autowired
private ObjectMapper objectMapper;

    @Test
    public void testGetPizzaById() throws Exception{
        Pizza newPizza = new Pizza();
        ResultActions resultActions = mockMvc
                .perform(get("/api/pizzas/pizza/{id}", 1L)
                .with(httpBasic("admin","admin"))
       .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPizza)));
        resultActions.andExpect(status().isOk());
    }
}
