package com.projectone.projectone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getInventory() {
        List<Inventory> inventory = inventoryService.getInventory();
        return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Inventory>> getInventoryByWarehouse(@PathVariable Warehouse warehouseId) {
        List<Inventory> inventory = inventoryService.findInventoryByWarehouseId(warehouseId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/tire-type/{tireTypeId}")
    public ResponseEntity<List<Inventory>> getInventoryByTireType(@PathVariable TireType tireTypeId) {
        List<Inventory> inventory = inventoryService.findInventoryByTireType(tireTypeId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}/tire-type/{tireTypeId}")
    public ResponseEntity<Inventory> getInventoryByWarehouseAndTireType(
            @PathVariable Warehouse warehouseId, @PathVariable TireType tireTypeId) {
        Inventory inventory = inventoryService.findInventoryByWarehouseAndTireType(warehouseId, tireTypeId);
        if (inventory != null) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<Inventory>> getAvailableInventory() {
        List<Inventory> inventory = inventoryService.findAvailableInventory();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<Inventory>> getLowStockInventory() {
        List<Inventory> inventory = inventoryService.findLowStockInventory();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
