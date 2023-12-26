package com.example.probe.Repository;


import com.example.probe.Entity.Users;
import com.example.probe.Service.UsersService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
Users findUsersByUsername (String username);
}
