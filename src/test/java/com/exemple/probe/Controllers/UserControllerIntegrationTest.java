package com.exemple.probe.Controllers;

import com.example.probe.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
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
@Ignore
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
       User newUser = new User(); // Создаем нового пользователя для теста
        newUser.setFirstName("Test User");
        String newUserJson = objectMapper.writeValueAsString(newUser);

        MvcResult postResult = mockMvc.perform(post("/api/user/create-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUserJson))
                .andExpect(status().isOk())
                .andReturn();

       // String postResponse = postResult.getResponse().getContentAsString();
       // User createdUser = objectMapper.readValue(postResponse, User.class);

        // Проверяем успешное создание пользователя
        // Здесь могут быть дополнительные проверки, например, сравнение данных созданного пользователя с данными, которые вы отправили

        // Тест для GET /api/user/get-user/{id}
        //mockMvc.perform(get("/api/user/get-user/{id}", createdUser.getUser_id()))
          //      .andExpect(status().isOk())
            //    .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Тест для PUT /api/user/update/{id}
        //createdUser.setName("Updated Test User");
        //String updatedUserJson = objectMapper.writeValueAsString(createdUser);

        //mockMvc.perform(put("/api/user/update/{id}", createdUser.getUser_id())
          //              .contentType(MediaType.APPLICATION_JSON)
            //            .content(updatedUserJson))
              //  .andExpect(status().isOk());

        // Тест для DELETE /api/user/delete/{id}
        //mockMvc.perform(delete("/api/user/delete/{id}", createdUser.getUser_id()))
          //      .andExpect(status().isOk());
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
