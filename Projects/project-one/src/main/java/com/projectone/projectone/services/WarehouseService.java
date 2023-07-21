package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.repositories.WarehouseRepository;
import java.util.List;
import java.util.Optional;

/*
 * Service class for my warehouses
 */

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    InventoryService inventoryService;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

     // Returns a list of every warehouse
    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // second
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

    // Getting the inventory count for a specifc warehouse
    public int getInventoryCountByWarehouseId(int warehouseId) {
        List<Inventory> inventory = inventoryService.getInventory();
        int count = 0;
        for (Inventory item : inventory) {
            if (item.getWarehouse().getWarehouseId() == warehouseId) {
                count += item.getQuantity();
            }
        }
        return count;
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Creates a warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // Update an existing warehouse
    public Warehouse updateWarehouse(Warehouse warehouse) {
            return warehouseRepository.save(warehouse);
    }

    // Delete a warehouse
    public void deleteWarehouse(Warehouse warehouse) {
        warehouseRepository.delete(warehouse);
    }
}

