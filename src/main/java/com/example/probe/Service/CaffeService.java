package com.example.probe.Service;

import com.example.probe.Entity.Caffe;
import com.example.probe.Repository.CaffeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;



@Service
@AllArgsConstructor

public class CaffeService {

    private final CaffeRepository caffeRepository;
    public List<Caffe> getAllCaffe(){
        return caffeRepository.findAll();
    }
    public Caffe getCaffeById(Long caffeId){
        return caffeRepository.findById(caffeId).orElse(null);
    }
    public Caffe createCaffe(Caffe caffe){
        return caffeRepository.save(caffe);
    }
    public Caffe updateCaffe(Long caffeId, Caffe updateCaffe) {
        Caffe caffe1 = caffeRepository.findById(caffeId).orElse(null);
        if (caffe1 != null) {
            caffe1.setNameCaffe(updateCaffe.getNameCaffe());
            caffe1.setCity(updateCaffe.getCity());
            caffe1.setAddress(updateCaffe.getAddress());
            caffe1.setEmail(updateCaffe.getEmail());
            caffe1.setPhone(updateCaffe.getPhone());
            caffe1.setOpen_at(Time.valueOf(updateCaffe.getOpen_at().toLocalTime()));
            caffe1.setClosed_at(Time.valueOf(updateCaffe.getClosed_at().toLocalTime()));
            return caffeRepository.save(caffe1);
        }
        return null;
    }

    public void deleteCaffe(Long caffeID){
        caffeRepository.deleteById(caffeID);
    }
}
