package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.repositories.WarehouseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    /*
     * GET INFORMATION
     *  - All
     *  - ById
     *  - ByName
     */

     // Returns a list of every warehouse
    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // Returns a single warehouse given its ID, or null otherwise
    public Warehouse findWarehouseById(int warehouseId) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(warehouseId);
        if (warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    // Returns a single warehouse given its name, or null otherwise
    public Warehouse findBywarehouseName(String warehouseName) {
        Optional<Warehouse> warehouse = warehouseRepository.findBywarehouseName(warehouseName);
        if (warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    /*
     * POSTING / PUTTING
     *  - create warehouse
     * 
     * 
     */

    // Creates a warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

}

