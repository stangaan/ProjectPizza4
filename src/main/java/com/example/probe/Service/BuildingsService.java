package com.example.probe.Service;

import com.example.probe.Entity.Tables;
import com.example.probe.Repository.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class BuildingsService {
    private final BuildingRepository buildingRepository;

    @Autowired
    public List<Tables> getAllTables(){return buildingRepository.findAll();}
    public Tables getTablesById(Long tableID){return buildingRepository.findById(tableID).orElse(null);}
    public Tables createTables(Tables tables){
        return buildingRepository.save(tables);
    }
    public Tables updateTables(Long tableID, Tables updateTables){
        Tables tables =  buildingRepository.findById(tableID).orElse(null);
        if(tables != null){
            tables.setBuildingName(updateTables.getBuildingName());
            tables.setNumberTable(updateTables.getNumberTable());
            tables.setCreating(updateTables.getCreating());
            tables.setOrders((updateTables.getOrders()));
            tables.setVisitors(updateTables.getVisitors());
            tables.setQuantityOrders(updateTables.getQuantityOrders());
            tables.setOrders(updateTables.getOrders());
            buildingRepository.save(tables);

        }
return null;
    }
    public void deleteTables(Long tableID){
        buildingRepository.deleteById(tableID);
    }
}
