package com.example.probe.Autorisation;

import com.example.probe.Entity.RegisterUsers;
import com.example.probe.Repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// источник UserDetail
// получает пользователей из их хранилища и мапит на UserDetail
@Service
public class UserDetailSource implements UserDetailsService {

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         RegisterUsers registerUsers = (RegisterUsers) registerUserRepository.getUserByUsername(username);
        if (registerUsers == null)
            throw new UsernameNotFoundException("User with username " + username + " not found");
    return new UserData(registerUsers);
}
}
