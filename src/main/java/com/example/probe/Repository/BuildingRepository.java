package com.example.probe.Repository;

import com.example.probe.Entity.Tables;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BuildingRepository extends JpaRepository<Tables,Long> {
}
