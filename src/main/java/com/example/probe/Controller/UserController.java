package com.example.probe.Controller;

import com.example.probe.Entity.User;
import com.example.probe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;
    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

        @GetMapping
                public List<User> getAllUser(){
            return (List<User>) userService.getAllUsers();
        }
        @GetMapping("/get-user{id}")
    public List<User> getUserById(@PathVariable Long id){
        return userService.getAllUsers();
        }
        @PostMapping
    public User createUser(@RequestBody User user){
         return userService.createUser(user);
        }
        @PutMapping("/update{id}")
    public User updateUser (@PathVariable Long id, @RequestBody User updatedUser){
      return userService.updateUser(id, updatedUser);
        }
        @DeleteMapping("/delete{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        }

    }

