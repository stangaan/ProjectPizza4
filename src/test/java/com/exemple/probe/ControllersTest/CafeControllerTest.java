package com.exemple.probe.ControllersTest;
import com.example.probe.Entity.Cafe;
import com.example.probe.ProbeApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ProbeApplication.class)
@AutoConfigureMockMvc
class CafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;
@BeforeEach
public void setUp(){
    objectMapper = new ObjectMapper();
}
    @Test
    public void testCreateCafe() throws Exception {
        // Создаем объект Cafe для отправки в запросе
        Cafe cafe = new Cafe();
        cafe.setNameCafe("Название кафе");
        cafe.setCity("Test");
        cafe.setEmail("nan@");
        cafe.setAddress("Адрес кафе");
        // Отправляем POST запрос
        ResultActions result = mockMvc.perform(post("/new-cafe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cafe)));

        // Проверяем, что статус ответа - 201 (Created)
        result.andExpect(status().isCreated());
        // Можете добавить дополнительные проверки, например, проверку содержимого ответа
    }
}
