package com.example.probe.Controller;

import com.example.probe.Entity.User;
import com.example.probe.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

@GetMapping("/user")
public String hello(){return "<h2> Hello user!!!</h2>";}
    @GetMapping("/all-users")
    public List<User> getAllUsers(){return userService.getAllUsers();}
    @GetMapping(
                "/get-user{id}")
    public List<User> getUserById(@PathVariable Long id){
        return userService.getAllUsers();
        }
        @PostMapping("create-user")
    public User createUser(@RequestBody User user){
         return userService.createUser(user);
        }
        @PutMapping("update{id}")
    public User updateUser (@PathVariable Long id, @RequestBody User updatedUser){
      return userService.updateUser(id, updatedUser);
        }
        @DeleteMapping("/delete{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        }

    }

