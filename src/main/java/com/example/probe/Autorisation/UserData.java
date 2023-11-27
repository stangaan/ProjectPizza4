package com.example.probe.Autorisation;

import com.example.probe.Entity.RegisterUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// UserDetails это встроенная в спринг модель пользователя
// модель безопасности
// наща задача замапить модель нашего пользователся в спринговую

public class UserData implements UserDetails {

    private RegisterUsers registerUsers; // наша модель

    public UserData(RegisterUsers registerUsers) {
    }

    // роли в модели пользователя спринг

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return registerUsers.getPassword();
    }

    @Override
    public String getUsername() {
        return registerUsers.getUsername();
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
