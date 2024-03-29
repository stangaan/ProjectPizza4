package com.exemple.probe.controllersTest;

import com.example.probe.entity.Pizza;
import com.example.probe.entity.Users;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = ProbeApplication.class)
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateUser() throws Exception {
        Users users = new Users();
        users.setFirstName("Test");
        users.setFirstName("FirsTest");
        users.setUserId(users.userId);
        users.setUserName("TestUser");
        users.setRoles("USER");
        users.setStation("TestIT");
        users.setPassword("Test777");
        users.setEMail("nanTest");
        ResultActions result = mockMvc
                .perform(post(
                        "/api/user/create-users")
                        .with(httpBasic("admin", "admin"))
                        .content(objectMapper.writeValueAsBytes(users)));
        result.andExpect(status().isOk());
    }

    @Test
    public void testAllUser() throws Exception {
        Users users = new Users();

        ResultActions resultActions;
        resultActions = mockMvc
                .perform(get("/api/user/all-users")

                        .with(httpBasic("admin", "admin"))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(users)));
        resultActions.andExpect(status().isOk());
    }
}
