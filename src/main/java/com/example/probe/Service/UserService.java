package com.example.probe.Service;

import com.example.probe.Entity.User;
import com.example.probe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
    return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);

    }
    public User updateUser(Long id, User updatedUser){
    User user1 = userRepository.findById(id).orElse(null);
        if (user1 != null){
            user1.setFirstName(updatedUser.getFirstName());
            user1.setLastName(updatedUser.getLastName());
            user1.setRoll(updatedUser.getRoll());
            user1.setStation(updatedUser.getStation());
            return userRepository.save(user1);
        }
        return null;
        }

    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }
}
