package com.example.probe.Autorisation;

import com.example.probe.Entity.UserRoles;
import com.example.probe.Entity.Users;
import com.example.probe.Repository.UsersRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


@Service
public class UserDetailSource implements UserDetailsService {

    public UsersRepository usersRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =  usersRepository.findUsersByUsername(username);
        if (users == null)
            throw new UsernameNotFoundException("User with username " + username + " not found");


        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), getAuthorities());

    }
    private Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Префикс "ROLE_" для каждой роли
                .collect(Collectors.toList());
    }
}

