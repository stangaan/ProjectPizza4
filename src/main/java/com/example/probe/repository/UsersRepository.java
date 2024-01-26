package com.example.probe.repository;


import com.example.probe.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
Users findUsersByUserName (String userName);
}
