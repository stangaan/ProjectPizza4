package com.example.probe.Repository;


import com.example.probe.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
Users findUsersByUserName (String userName);
}
