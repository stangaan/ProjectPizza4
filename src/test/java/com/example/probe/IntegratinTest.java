package com.example.probe;

import com.example.probe.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.http.HttpHeaders;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegratinTest {

    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public  void createUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");

        HttpEntity<String> request = new HttpEntity<>("{\n" +
                "    \"firstName\": \"Stengauar\",\n" +
                "    \"lastName\": \"Andrei\",\n" +
                "    \"roll\": \"Admin\",\n" +
                "    \"station\": \"IT\",\n" +
                "    \"password\": \"7777777\"\n"},
                headers

    );
        void assertEquals (userRepository.count(),0);
        String result = restTemplate.postForEntity(
                "http://localhost:" + port + "/users",
                request,
                String.class
        ).getBody();
    }
}
