package com.example.probe.Repository;

import com.example.probe.Entity.Caffe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaffeRepository extends JpaRepository<Caffe, Long> {

}
