package com.example.probe.Repository;

import com.example.probe.Entity.RegisterUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends CrudRepository<RegisterUsers, Long> {

    RegisterUsers getUserByUsername(String username);
}
