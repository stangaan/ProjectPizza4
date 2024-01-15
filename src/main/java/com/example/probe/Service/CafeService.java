package com.example.probe.Service;

import com.example.probe.Entity.Cafe;
import com.example.probe.Repository.CafeRepository;
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
    public Cafe getCafeById(Long cafeId){
        return cafeRepository.findById(cafeId).orElse(null);
    }
    public Cafe createCafe(Cafe cafe){
        return cafeRepository.save(cafe);
    }
    public Cafe updateCafe(Long cafeId, Cafe updateCafe) {
        Cafe cafe1 = cafeRepository.findById(cafeId).orElse(null);
        if (cafe1 != null) {
            cafe1.setNameCafe(updateCafe.getNameCafe());
            cafe1.setCity(updateCafe.getCity());
            cafe1.setAddress(updateCafe.getAddress());
            cafe1.setEmail(updateCafe.getEmail());
            cafe1.setPhone(updateCafe.getPhone());
            cafe1.setOpen_at(Time.valueOf(updateCafe.getOpen_at().toLocalTime()));
            cafe1.setClosed_at(Time.valueOf(updateCafe.getClosed_at().toLocalTime()));
            return cafeRepository.save(cafe1);
        }
        return null;
    }

    public void deleteCafe(Long cafeId){
        cafeRepository.deleteById(cafeId);
    }
}
