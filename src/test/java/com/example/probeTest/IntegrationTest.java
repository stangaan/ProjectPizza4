package com.example.probeTest;

import com.example.probe.Entity.Users;
import com.example.probe.Repository.UsersRepository;
import com.example.probe.Service.UsersService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Value(value = "${local.server.port}")
    private int port;



    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testReadUsers() {
        ResponseEntity<Users> response = restTemplate
                .withBasicAuth("admin", "admin")
                .getForEntity("http://localhost/:" + port + "/api/user/get-user/", Users.class)
                ;
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("admin", response.getBody().getUserName());
        assertEquals("ADMIN", response.getBody().getRoles());
    }}
