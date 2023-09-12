package com.example.probe.Repository;

import com.example.probe.Entity.Drinks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Long> {

}
