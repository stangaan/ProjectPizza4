package com.exemple.probe.Controllers;

import com.example.probe.Entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;
    @Test
    public void testUserControllerEndpoints() throws Exception {
        // Тест для GET /api/user/all-users
        mockMvc.perform(get("/api/user/all-users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Тест для POST /api/user/create-user
       Users newUser = new Users(); // Создаем нового пользователя для теста
        newUser.setFirstName("Test User");
        String newUserJson = objectMapper.writeValueAsString(newUser);

        MvcResult postResult = mockMvc.perform(post("/api/user/create-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUserJson))
                .andExpect(status().isOk())
                .andReturn();

        String postResponse = postResult.getResponse().getContentAsString();
        Users createdUser = objectMapper.readValue(postResponse, Users.class);

        // Проверяем успешное создание пользователя
        // Здесь могут быть дополнительные проверки, например, сравнение данных созданного пользователя с данными, которые вы отправили
//
//        // Тест для GET /api/user/get-user/{id}
//        MvcResult perform(get("/api/user/get-user/{id}", createdUser.getId()))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

// Тест для GET /api/user/get-user/{id}
        MvcResult result = mockMvc.perform(get("/api/user/get-user/{id}", createdUser.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


       //  Тест для PUT /api/user/update/{id}
        createdUser.setFirstName("Updated Test User");
        String updatedUserJson = objectMapper.writeValueAsString(createdUser);

        mockMvc.perform(put("/api/user/update/", createdUser.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                      .content(updatedUserJson))
                     .andExpect(status().isOk());

        // Тест для DELETE /api/user/delete/{id}
        mockMvc.perform(delete("/api/user/delete/{id}", createdUser.getId()))
              .andExpect(status().isOk());
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
