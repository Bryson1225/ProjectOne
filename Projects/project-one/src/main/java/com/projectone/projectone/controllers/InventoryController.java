package com.projectone.projectone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.services.InventoryService;

// Controller class for my inventory

@RestController
@RequestMapping("/inventory")
@CrossOrigin("http://localhost:5173")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get the whole inventory
    @GetMapping
    public ResponseEntity<List<Inventory>> getInventory() {
        List<Inventory> inventory = inventoryService.getInventory();
        System.out.println(inventory);
        return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

    // Get the inventory at a specifc warehouse
    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Inventory>> getInventoryByWarehouse(@PathVariable Warehouse warehouseId) {
        List<Inventory> inventory = inventoryService.findInventoryByWarehouseId(warehouseId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    // Get the inventory information on a tire type given its id
    @GetMapping("/tire-type/{tireTypeId}")
    public ResponseEntity<List<Inventory>> getInventoryByTireType(@PathVariable TireType tireTypeId) {
        List<Inventory> inventory = inventoryService.findInventoryByTireType(tireTypeId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    // Get the inventory of a tire type (with its id) at a given warehouse
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

    // Get all available inventory
    @GetMapping("/available")
    public ResponseEntity<List<Inventory>> getAvailableInventory() {
        List<Inventory> inventory = inventoryService.findAvailableInventory();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    // Get inventory that is low and may need restocked
    @GetMapping("/low-stock")
    public ResponseEntity<List<Inventory>> getLowStockInventory() {
        List<Inventory> inventory = inventoryService.findLowStockInventory();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Modify the inventory at a certain warehouse
    @PutMapping("/{warehouseId}/{tireTypeId}")
    public ResponseEntity<Inventory> updateInventoryQuantity(
            @PathVariable Warehouse warehouseId,
            @PathVariable TireType tireTypeId,
            @RequestParam Integer quantity
    ) {
        Inventory updatedInventory = inventoryService.updateInventoryQuantity(warehouseId, tireTypeId, quantity);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    @PostMapping("/create-inventory/{warehouseId}/{tireTypeId}")
    public ResponseEntity<Inventory> createInventory(
        @PathVariable Warehouse warehouseId,
        @PathVariable TireType tireTypeId,
        @RequestBody Inventory inventory
    ) {
        Inventory createdInventory = inventoryService.createInventory(warehouseId, tireTypeId, inventory);
        return new ResponseEntity<>(createdInventory, HttpStatus.CREATED);
    }
}

