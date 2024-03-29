package com.example.probe.autorisation;

import com.example.probe.entity.Users;
import com.example.probe.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

// UserDetails это встроенная в спринг модель пользователя
// модель безопасности
// наща задача замапить модель нашего пользователся в спринговую

public class UsersData implements UserDetails {

    UsersRepository usersRepository;

    private Users users; // наша модель


public UsersData(Users users){this.users= users;}



    // роли в модели пользователя спринг



    public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority(users.getRoles()));

    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
