package com.exemple.probe.controllersTest;

import com.example.probe.entity.Pizza;
import com.example.probe.ProbeApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ProbeApplication.class)
@AutoConfigureMockMvc
public class PizzaControllerTest {
@Autowired
    private MockMvc mockMvc;
private ObjectMapper objectMapper;
@BeforeEach
    public void setUp(){
    objectMapper = new ObjectMapper();
}
@Test
    public void testCreatePizza() throws Exception{
    Pizza pizza = new Pizza();
    pizza.setNamePizza("TestPizza");
    pizza.setSize(100);
    pizza.setIngredients("cheese");
    pizza.setPrice(100);
    pizza.setQuantity("100");

    ResultActions resultActions = mockMvc
            .perform(post("/api/pizzas/new-pizza")
                    .with(httpBasic("admin","admin"))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(pizza)));
    resultActions.andExpect(status().isOk());

}
    @Test
    public void testAllPizza() throws Exception{
        Pizza pizza = new Pizza();
        pizza.setNamePizza("TestPizza");
        pizza.setSize(100);
        pizza.setIngredients("cheese");
        pizza.setPrice(100);
        pizza.setQuantity("100");
        ResultActions resultActions = mockMvc
                .perform(get("/api/pizzas/pizza")
                        .with(httpBasic("admin", "admin"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pizza)));
        resultActions.andExpect(status().isOk());
    }
}
