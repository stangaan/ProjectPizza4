package com.example.probe.service;

import com.example.probe.entity.Cafe;
import com.example.probe.repository.CafeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;



@Service
@AllArgsConstructor

public class CafeService {

    private final CafeRepository cafeRepository;
    public List<Cafe> getAllCafe(){
        return cafeRepository.findAll();
    }
    public Cafe getCafeById(Long id ){
        return cafeRepository.findById(id). orElse(null);
    }
    public Cafe createCafe(Cafe cafe){
        return cafeRepository.save(cafe);
    }
    public Cafe updateCafe(Long id, Cafe updateCafe) {
        Cafe cafe1 = cafeRepository.findById(id).orElse(null);
        if (cafe1 != null) {
            cafe1.setNameCafe(updateCafe.getNameCafe());
            cafe1.setCity(updateCafe.getCity());
            cafe1.setAddress(updateCafe.getAddress());
            cafe1.setEmail(updateCafe.getEmail());
            cafe1.setPhone(updateCafe.getPhone());
            cafe1.setOpenAt(Time.valueOf(updateCafe.getOpenAt().toLocalTime()));
            cafe1.setClosedAt(Time.valueOf(updateCafe.getClosedAt().toLocalTime()));
            return cafeRepository.save(cafe1);
        }
        return null;
    }

    public void deleteCafe(Long id){
        cafeRepository.deleteById(id);
    }
}
