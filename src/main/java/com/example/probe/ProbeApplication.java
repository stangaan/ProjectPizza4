package com.example.probe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ProbeApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ProbeApplication.class, args);
       }

}
