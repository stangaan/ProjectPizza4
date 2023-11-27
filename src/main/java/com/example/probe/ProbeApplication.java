package com.example.probe;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProbeApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ProbeApplication.class, args);
       }

}
