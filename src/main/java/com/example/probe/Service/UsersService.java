package com.example.probe.Service;


import com.example.probe.Entity.Users;
import com.example.probe.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UsersService {

    private final UsersRepository usersRepository;
    @Autowired
    public UsersService (UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public Users getAllUsers() {return (Users) usersRepository.findAll();}

    public Users getUserById(Long id){return usersRepository.findById(id).orElse(null);}

    public Users createUsers(Users users){return usersRepository.save(users);}
    public Users updateUser(Long id, Users updateUser) {
        Users users1 = usersRepository.findById(id).orElse(null);
        if (users1 != null) {
            users1.setUsername(updateUser.getUsername());
            users1.setFirstName(updateUser.getFirstName());
            users1.setLastName(updateUser.getLastName());
            users1.setPassword(updateUser.getPassword());
            users1.setRoles(updateUser.getRoles());
            users1.setE_mail(updateUser.getE_mail());
            users1.setStation(updateUser.getStation());

        }
        return null;
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }


}
