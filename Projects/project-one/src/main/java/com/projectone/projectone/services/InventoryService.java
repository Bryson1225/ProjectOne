package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.repositories.InventoryRepository;

import java.util.List;

/*
 * Service class for my inventory
 */

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get the entire inventory
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    // Get an inventory for a specific warehouse
    public List<Inventory> findInventoryByWarehouseId(Warehouse warehouseId) {
        return inventoryRepository.findByWarehouseId(warehouseId);
    }

    // Get the inventory for a given tire type
    public List<Inventory> findInventoryByTireType(TireType tireTypeId) {
        return inventoryRepository.findByTireTypeId(tireTypeId);
    }

    // Get the inventory given a warehouse id and tire type
    public Inventory findInventoryByWarehouseAndTireType(Warehouse warehouseId, TireType tireTypeId) {
        return inventoryRepository.findByWarehouseIdAndTireTypeId(warehouseId, tireTypeId);
    }

    // Get all available inventory
    public List<Inventory> findAvailableInventory() {
        return inventoryRepository.findByQuantityGreaterThan(0);
    }

    // Get all inventory items that may need restocking
    public List<Inventory> findLowStockInventory() {
        // Define low stock threshold
        int lowStockThreshold = 100;
        return inventoryRepository.findByQuantityLessThan(lowStockThreshold);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Update items within the inventory
    public Inventory updateInventoryQuantity(Warehouse warehouseId, TireType tireTypeId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByWarehouseIdAndTireTypeId(warehouseId, tireTypeId);
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() + quantity);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

}

