package com.example.probe.Autorisation;

import com.example.probe.Entity.Users;
import com.example.probe.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailSource implements UserDetailsService {
@Autowired
    public UsersRepository usersRepository;
@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = usersRepository.findUsersByUserName(userName);
        if (users == null)
            throw new UsernameNotFoundException("User with username " + userName + " not found");


        return new UsersData(users);
        }

    }



