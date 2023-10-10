package com.example.probe.Autorisation;
import com.example.probe.Repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {
    RegistrationRepository registrationRepository;
    private final JdbcUserDetailsManager userDetailsManager;


    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        // Создаем нового пользователя и добавляем его в базу данных
        UserDetails user = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);

        return "redirect:/login"; // Перенаправляем пользователя на страницу входа
    }
}
