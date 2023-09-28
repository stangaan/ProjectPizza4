package com.example.probe.Controller;

import com.example.probe.Entity.Tables;
import com.example.probe.Service.BuildingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Service
@RequestMapping("/api/buildings")
public class BuildingsController {
    private  final BuildingsService buildingsService;

    @GetMapping("/Table")
    public List<Tables> getAllTables(){return buildingsService.getAllTables();}

    @GetMapping("/table{id}")
    public Tables getTablesById(@PathVariable Long TableID){return buildingsService.getTablesById(TableID);}
    @PostMapping("/new-table")
    public Tables createTable(@RequestBody Tables tables){
        return buildingsService.createTables(tables);
    }
    @PutMapping("/update{id}")
    public Tables updateTables(@PathVariable Long TableID, @RequestBody Tables updateTables){
        return buildingsService.updateTables(TableID, updateTables);
    }
    @DeleteMapping("/deleteTables")
    public Tables deleteTables(@PathVariable Long TableID){buildingsService.deleteTables(TableID);
        return null;
    }

}
