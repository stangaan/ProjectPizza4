package com.example.probe.Autorisation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static java.util.Base64.getEncoder;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


@Autowired
    private UserDetailSource source;




    @Bean
    public NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(noOpPasswordEncoder());
        provider.setUserDetailsService(source);
        return provider;

   }

    @Bean
    public SecurityFilterChain getChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/api/pizzas/pizza")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/api/caffe/all")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.POST, "/api/pizzas/new-pizza")).hasAnyRole("ADMIN")
                                        //.requestMatchers(antMatcher(HttpMethod.PUT, "/api/pizzas/update")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/pizzas/delete")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/cafe/new-caffe")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.PUT,"/api/cafe/update")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/cafe/delete")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.GET,"/api/user/get-user")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/user/create-user")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/update{{id}}")).hasAnyRole("ADMIN", "USER")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE, "/api/user/delete")).permitAll()
                                        .anyRequest().authenticated())
                .formLogin()
                .and()
                .csrf() // выключается csrf
                .disable().headers()
                .frameOptions()
                .disable()
                .and()
                .httpBasic(Customizer.withDefaults()) // basic - добавляется заголок
                .logout() // /logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                ;
        // при логауте удаляется сессия
                        // и кука
return http.build();

    }
}



