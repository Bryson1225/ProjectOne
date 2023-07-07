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

    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse findWarehouseById(int id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        if (warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    public Warehouse findWarehouseByName(String name) {
        Optional<Warehouse> warehouse = warehouseRepository.findWarehouseByName(name);
        if (warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    public List<Warehouse> findWarehouseByLocation(String location) {
        Optional<List<Warehouse>> warehouse = warehouseRepository.findWarehouseByLocation(location);
        if (warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    /**
     * POSTING / PUTTING
     */
    
    // Create a new warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // Update warehouse capacity
    public int updateCapacity(Warehouse warehouse, int newCapacity) {
        return warehouseRepository.updateWarehouseCapacity(warehouse.getWarehouseId(), newCapacity);
    }
}

