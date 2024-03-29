package com.example.probe.service;


import com.example.probe.entity.Users;
import com.example.probe.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UsersService (UsersRepository usersRepository, PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(String userName, String password) {
        String hashedPassword = passwordEncoder.encode(password);
        Users users = new Users();
        users.setUserName(userName);
        users.setPassword(hashedPassword);
        usersRepository.save(users);
    }
    public Iterable <Users> getAllUsers() {return  usersRepository.findAll();}

    public Users getUserById(Long id){return usersRepository.findById(id).orElse(null);}

    public Users createUsers(Users users){return usersRepository.save(users);}
    public Users updateUser(Long id, Users updateUser) {
        Users users1 = usersRepository.findById(id).orElse(null);
        if (users1 != null) {
            users1.setUserName(updateUser.getUserName());
            users1.setFirstName(updateUser.getFirstName());
            users1.setLastName(updateUser.getLastName());
            users1.setPassword(updateUser.getPassword());
            users1.setRoles(updateUser.getRoles());
            users1.setEMail(updateUser.getEMail());
            users1.setStation(updateUser.getStation());
        }
        return null;
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }



}
