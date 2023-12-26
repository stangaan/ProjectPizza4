package com.example.probe.Autorisation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Autowired
    private UserDetailsService userDetailsService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/index.html")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/open")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/api/")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/pizzas/new-pizza/")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/pizzas/update")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/pizzas/delete")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/caffe/new-caffe")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/caffe/update")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/caffe/delete")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/user/get-user")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/user/create-user")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/update{{id}}")).hasAnyRole("ADMIN")
                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/user/delete{{id}}")).hasAnyRole("ADMIN")
//                // Укажите другие URL и права доступа
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .httpBasic();
    }
}

//@Configuration // методы класса являются источниками конфигурационных @Bean
//@EnableWebSecurity // внутри класса настраивается доступ к url
//public class SecurityConfiguration {
//
//    private UserDetailsService userDetailsService; // Убедитесь, что у вас есть бин UserDetailsService
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider()); // Установите UserDetailsService
//        // Здесь также можете настроить другие параметры аутентификации
//    }
//
//    public UserDetailSource source;
//
//    // механизм проверки паролей
//    // NoOpPasswordEncoder - пароль не шифруется
//    // BCryptPasswordEncoder - используется BCrypt
//    // сгенерировать BCrypt пароли можно в https://bcrypt-generator.com/
//    @Bean
//    public static PasswordEncoder getEncoder() {
//        // return NoOpPasswordEncoder.getInstance();
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    // AuthenticationProvider связывает между собой
//    // источник UserDetail о пользователях и
//    // механизм проверки их паролей
//    @Bean
//    public AuthenticationProvider authenticationProvider()
//    {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(getEncoder());
//        provider.setUserDetailsService(source);
//        return provider;
//    }
//
//    // SecurityFilterChain используется для настройки url которые защищаются
//    @Bean
//    public SecurityFilterChain getChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(
//                        auth ->
//                                auth
//                                        //.requestMatchers(toH2Console()).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.GET, "/index.html")).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.GET, "/open")).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.GET, "/")).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.POST,"/api/pizzas/new-pizza/")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/api/pizzas/update")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/pizzas/delete")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/caffe/new-caffe")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.PUT,"/api/caffe/update")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/caffe/delete")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.GET,"/api/user/get-user")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/user/create-user")).hasAnyRole("ADMIN")
//                                        //.requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/update{{id}}")).hasAnyRole("ADMIN")
//                                       // .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/user/delete{{id}}")).hasAnyRole("ADMIN")
//                                        .anyRequest().authenticated() // все остальные только требуют аутентификации
//                )
//                .formLogin()// стандартная форма для аутентификации
//                .and()
//                .csrf() // выключается csrf
//                .disable()
//                .headers().frameOptions().disable()
//                .and()
//                .httpBasic(Customizer.withDefaults()) // basic - добавляется заголок
//                .logout() // /logout
//                .invalidateHttpSession(true)// при логауте удаляется сессия
//                .deleteCookies("JSESSIONID"); // и кука
//
//        return http.build();
//    }

