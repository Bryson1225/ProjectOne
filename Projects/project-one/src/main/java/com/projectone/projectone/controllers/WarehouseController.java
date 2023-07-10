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


/*
 * Class: WarehouseController.java
 * Function: This is the controller class for our Warehouse.java
 * 
 * Instance Variables
 *  - warehouseService - Reference to the service class.
 */

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    @Autowired
    WarehouseService warehouseService;


    /**
     * GET SECTION
     *  - AllWarehouses
     *  - ById
     *  - warehouseName
     */

    @GetMapping // Grab all warehouses
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.findAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{warehouseId}") // Single warehouse with an Id
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int warehouseId) {
        Warehouse warehouse = warehouseService.findWarehouseById(warehouseId);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    @GetMapping("/name/{warehouseName}") // Get a warehouse by its name
    public ResponseEntity<Warehouse> findBywarehouseName(@PathVariable String warehouseName) {
        Warehouse warehouse = warehouseService.findBywarehouseName(warehouseName);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    /**
     * ADDING INFORMATION SECTION
     *  - POST
     *      - create
     */

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
        // Need to make sure that the warehouse is empty.
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
