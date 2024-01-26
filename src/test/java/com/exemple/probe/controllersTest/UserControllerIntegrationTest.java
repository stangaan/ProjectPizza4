package com.exemple.probe.controllersTest;

import com.example.probe.ProbeApplication;
import com.example.probe.controller.UsersController;
import com.example.probe.entity.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProbeApplication.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    //@BeforeEach
            // public void setUp(){
        //objectMapper = new ObjectMapper();


    @org.junit.Test
    public void  testUserEndpoints() throws Exception {
        // Тест для GET /api/user/all-users
        ResultActions resultActions = mockMvc.perform(get("/api/user/all-users")
                .with(httpBasic("admin", "admin"))
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
    }
        // Тест для POST /api/user/create-user
        @Test
                public void testCreateUser() throws Exception{
        Users newUser = new Users(); // Создаем нового пользователя для теста
        ResultActions resultActions1 = mockMvc.perform(post("/api/user/create-users")
                .with(httpBasic("admin", "admin"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)));
        resultActions1.andExpect(status().isOk());
    }

       // MvcResult postResult = mockMvc.perform(post("/api/user/create-user")
         //               .contentType(MediaType.APPLICATION_JSON)
           //             .content(newUserJson))
             //   .andExpect(status().isOk())
               // .andReturn();

        //String postResponse = postResult.getResponse().getContentAsString();
        //Users createdUser = objectMapper.readValue(postResponse, Users.class);

        // Проверяем успешное создание пользователя
        // Здесь могут быть дополнительные проверки, например, сравнение данных созданного пользователя с данными, которые вы отправили
//
      // Тест для GET /api/user/get-user/{id}
    @org.junit.Test
                public void testGetUserWithAuthorization() throws Exception {
        ResultActions resultActions2 = mockMvc.perform(get("/api/user/get-user/1", 1L)
                .with(httpBasic("admin", "admin")));
        resultActions2.andExpect(status().isOk());
    }
// Тест для GET /api/user/get-user/{id}
        //MvcResult result = mockMvc.perform(get("/api/user/get-user/{id}", createdUsers.getId())
                 //       .contentType(MediaType.APPLICATION_JSON))
               // .andExpect(status().isOk())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
              // .andReturn();


       //  Тест для PUT /api/user/update/{id}
        //createdUser.setFirstName("Updated Test User");
 //       String updatedUserJson = objectMapper.writeValueAsString(createdUser);

   //     mockMvc.perform(put("/api/user/update/", createdUser.getId())
     //                   .contentType(MediaType.APPLICATION_JSON)
       //               .content(updatedUserJson))
         //            .andExpect(status().isOk());

        // Тест для DELETE /api/user/delete/{id}
    @org.junit.Test
        public void testDeleteUserWithAuthorization() throws Exception{
        Users users = new Users();
            ResultActions resultActions = mockMvc
                    .perform(delete("/api/user/delete/{id}",1L)
                            .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin")));
            resultActions.andExpect(status().isOk());
        }


}
