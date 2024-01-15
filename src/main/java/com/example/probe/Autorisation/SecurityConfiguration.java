package com.example.probe.Autorisation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

@Autowired
    private UserDetailSource createPizza;
    private UserDetailSource updatePizza;
    private UserDetailSource deletePizza;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public static NoOpPasswordEncoder getEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getEncoder());
        provider.setUserDetailsService(createPizza);
        return provider;

   }


//    protected void configure(HttpSecurity http) throws Exception {
//      http.authorizeRequests()
//                                        .requestMatchers(antMatcher(HttpMethod.GET, "/api/")).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/pizzas/pizza")).permitAll()
//                                        .requestMatchers(antMatcher(HttpMethod.POST,"/new-pizza/")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/update")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/delete")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.POST,"/new-caffe")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/update")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/delete")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.GET,"/get-user")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.POST,"/create-user")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.PUT,"/update")).hasAnyRole("ADMIN")
//                                        .requestMatchers(antMatcher(HttpMethod.DELETE,"/delete")).hasAnyRole("ADMIN")
////                //
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .httpBasic();
//    }

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

//
//    // AuthenticationProvider связывает между собой
//    // источник UserDetail о пользователях и
//    // механизм проверки их паролей

//
//    // SecurityFilterChain используется для настройки url которые защищаются
    @Bean
    public SecurityFilterChain getChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/api/pizzas/pizza")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET,"/api/cafe/all")).permitAll()
                                        //.requestMatchers(antMatcher(HttpMethod.POST, "/api/pizzas/new-pizza/")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.PUT, "/api/pizzas/update")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/pizzas/delete")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/caffe/new-caffe")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.PUT,"/api/caffe/update")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.DELETE,"/api/caffe/delete")).hasAnyRole("ADMIN", "USER")
                                       // .requestMatchers(antMatcher(HttpMethod.GET,"/api/user/get-user")).hasAnyRole("ADMIN", "USER")
                                        //.requestMatchers(antMatcher(HttpMethod.POST,"/api/user/create-user")).hasAnyRole("ADMIN", "USER")
                                       // .requestMatchers(antMatcher(HttpMethod.PUT,"/api/user/update{{id}}")).hasAnyRole("ADMIN", "USER")
                                     //   .requestMatchers(antMatcher(HttpMethod.DELETE,"/api/user/delete{{id}}")).hasAnyRole("ADMIN", "USER")
                                        .anyRequest().permitAll())
                                        .formLogin()
                                        .and()
                .csrf() // выключается csrf
                .disable()
                .headers()
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



