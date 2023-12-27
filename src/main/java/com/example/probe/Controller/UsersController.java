package com.example.probe.Controller;

import com.example.probe.Entity.Users;
import com.example.probe.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UsersController {
    private final UsersService usersService;


    @GetMapping("/user")
public String hello(){return "<h2> Hello user!!!</h2>";}
    @GetMapping("/all-users")
    public Users getAllUsers(){return usersService.getAllUsers();}
    @GetMapping(
                "/get-user{id}")
    public Users getUsersById(@PathVariable Long id){
        return usersService.getUserById(id);
        }
        @PostMapping("create-user")
    public Users createUsers(@RequestBody Users users){
         return usersService.createUsers(users);
        }
        @PutMapping("update{id}")
    public Users updateUser (@PathVariable Long id, @RequestBody Users updatedUser){
      return usersService.updateUser(id, updatedUser);
        }
        @DeleteMapping("/delete{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
        }

    }

