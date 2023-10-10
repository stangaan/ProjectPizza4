package com.example.probe.Repository;

import com.example.probe.Entity.RegisterUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegisterUsers, Long>{

}
