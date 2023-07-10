package com.projectone.projectone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.services.WarehouseService;

// Controller class for my warehouse

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    @Autowired
    WarehouseService warehouseService;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get all warehouses
    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.findAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    // Get a warehouse with an id
    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int warehouseId) {
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    // Get a warehouse by its name
    @GetMapping("/name/{warehouseName}")
    public ResponseEntity<Warehouse> findBywarehouseName(@PathVariable String warehouseName) {
        Warehouse warehouse = warehouseService.findBywarehouseName(warehouseName);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////f

    // Creating a new warehouse entity
    @PostMapping("/create-warehouse") // Create a newwarehouse
    public ResponseEntity<Warehouse> creatWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }

    // Update an existing warehouse
    @PutMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse updatedWarehouse) {
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        if (warehouse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        warehouse.setWarehouseName(updatedWarehouse.getWarehouseName());
        warehouse.setMaximumCapacity(updatedWarehouse.getMaximumCapacity());
        Warehouse newWarehouse = warehouseService.updateWarehouse(warehouse);
        return new ResponseEntity<>(newWarehouse, HttpStatus.OK);
    }

    // Delete a warehouse by ID
    @DeleteMapping("/warehouse/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        if (warehouse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        warehouseService.deleteWarehouse(warehouse);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
