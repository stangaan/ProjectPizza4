package com.example.probe.Autorisation;

import com.example.probe.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

import static com.example.probe.Entity.UserRolls.ADMIN;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    public UserRepository userRepository;

    @BeanserDetailsService userDetailsService(){
        List<U
    public User> user = userRepository.findAll();
        List<UserDetails> userDetails1 = new ArrayList<>();
        for (User user : users){
        UserDetails userDetails = User
                .withUsername(users.)
                .password()
                .roles(String.valueOf(ADMIN))
                .build();
        return new InMemoryUserDetailsManager(userDetails1);
    }
}
