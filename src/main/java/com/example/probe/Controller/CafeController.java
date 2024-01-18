package com.example.probe.Controller;


import com.example.probe.Entity.Cafe;
import com.example.probe.Service.CafeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/cafe")
@RestController
public class CafeController {
private  final CafeService cafeService;

    @GetMapping("/all")
        public List<Cafe> getAllCafe1(){return cafeService.getAllCafe();}
    @GetMapping ("/cafe/{id}")
    public Cafe getCafeById(@PathVariable Long id ){return cafeService.getCafeById(id);}
    @PostMapping ("/new-cafe")
    public Cafe createCafe(@RequestBody Cafe cafe){return cafeService.createCafe(cafe);}
    @PutMapping("/update/{id}")
    public Cafe updateCafe(@PathVariable Long id, @RequestBody Cafe updateCafe){return cafeService.updateCafe(id, updateCafe);}
    @DeleteMapping("/delete/{id}")
    public void deleteCafe(@PathVariable Long id){cafeService.deleteCafe(id);}

}
