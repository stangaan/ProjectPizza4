package com.example.probe.Autorisation;


import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration // методы класса являются источниками конфигурационных @Bean
@EnableWebSecurity // внутри класса настраивается доступ к url
public class SecurityConfiguration {


    @Autowired
    private UserDetailSource source;

    // механизм проверки паролей
    // NoOpPasswordEncoder - пароль не шифруется
    // BCryptPasswordEncoder - используется BCrypt
    // сгенерировать BCrypt пароли можно в https://bcrypt-generator.com/
    @Bean
    public static PasswordEncoder getEncoder() {
        // return NoOpPasswordEncoder.getInstance();
        return NoOpPasswordEncoder.getInstance();
    }

    // AuthenticationProvider связывает между собой
    // источник UserDetail о пользователях и
    // механизм проверки их паролей
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getEncoder());
        provider.setUserDetailsService(source);
        return provider;
    }

    // SecurityFilterChain используется для настройки url которые защищаются
    @Bean
    public SecurityFilterChain getChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        //.requestMatchers(toH2Console()).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/index.html")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/open")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/pizzas/new-pizza/")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/pizzas/update{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/pizzas/delete{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/caffe/new-caffe")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/caffe/update{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/caffe/delete{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/user/get-user{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/create-user")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/update{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/user/delete{{id}}")).hasAnyRole("ADMIN")
                                        .anyRequest().authenticated() // все остальные только требуют аутентификации
                )
                .formLogin()// стандартная форма для аутентификации
                .and()
                .csrf() // выключается csrf
                .disable()
                .headers().frameOptions().disable()
                .and()
                .httpBasic(Customizer.withDefaults()) // basic - добавляется заголок
                .logout() // /logout
                .invalidateHttpSession(true)// при логауте удаляется сессия
                .deleteCookies("JSESSIONID") // и кука
        ;

        return http.build();
    }
}
