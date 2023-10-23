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
    public Caffe getCaffeById(Long CaffeId){
        return caffeRepository.findById(CaffeId).orElse(null);
    }
    public Caffe createCaffe(Caffe caffe){
        return caffeRepository.save(caffe);
    }
    public Caffe updateCaffe(Long caffeId, Caffe updateCaffe) {
        Caffe caffe = caffeRepository.findById(caffeId).orElse(null);
        if (caffe != null) {
            caffe.setNameCaffe(updateCaffe.getNameCaffe());
            caffe.setCity(updateCaffe.getCity());
            caffe.setAddress(updateCaffe.getAddress());
            caffe.setEmail(updateCaffe.getEmail());
            caffe.setPhone(updateCaffe.getPhone());
            caffe.setOpenAt(Time.valueOf(toString()));
            caffe.setClosed_at(Time.valueOf(toString()));
            return caffeRepository.save(caffe);
        }
    return null;
    }
    public void deleteCaffe(Long caffeID){
        caffeRepository.deleteById(caffeID);
    }
}
