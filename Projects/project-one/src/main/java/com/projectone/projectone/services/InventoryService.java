package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> findInventoryByWarehouseId(Warehouse warehouseId) {
        return inventoryRepository.findByWarehouseId(warehouseId);
    }

    public List<Inventory> findInventoryByTireType(TireType tireTypeId) {
        return inventoryRepository.findByTireTypeId(tireTypeId);
    }

    public Inventory findInventoryByWarehouseAndTireType(Warehouse warehouseId, TireType tireTypeId) {
        return inventoryRepository.findByWarehouseIdAndTireTypeId(warehouseId, tireTypeId);
    }

    public List<Inventory> findAvailableInventory() {
        return inventoryRepository.findByQuantityGreaterThan(0);
    }

    public List<Inventory> findLowStockInventory() {
        // Define low stock threshold
        int lowStockThreshold = 100;
        return inventoryRepository.findByQuantityLessThan(lowStockThreshold);
    }

    /*
     * ADDING methods are below
     * 
     * 
     */

     public Inventory updateInventoryQuantity(Warehouse warehouseId, TireType tireTypeId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByWarehouseIdAndTireTypeId(warehouseId, tireTypeId);
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() + quantity);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

}

