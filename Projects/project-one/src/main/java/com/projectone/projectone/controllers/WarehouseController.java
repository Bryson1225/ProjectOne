package com.projectone.projectone.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.services.WarehouseService;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    @Autowired
    WarehouseService warehouseService;


    /**
     * GET SECTION
     */

    // Grab every warehouse within the DB
    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.findAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    // Grab a single specified warehouse
    @GetMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int id) {
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    // Grab a warehouse by name
    @GetMapping("/warehouse/{name}")
    public ResponseEntity<Warehouse> findWarehouseByName(@PathVariable String name) {
        Warehouse warehouse = warehouseService.findWarehouseByName(name);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    // Grab warehouse(s) by location
    @GetMapping("warehouses/{location}")
    public ResponseEntity<List<Warehouse>> findWarehouseByLocation(@PathVariable String location) {
        List<Warehouse> warehouse = warehouseService.findWarehouseByLocation(location);
        return new ResponseEntity<List<Warehouse>>(warehouse, HttpStatus.OK);
    }

    /**
     * ADDING INFORMATION SECTION
     */

    // Creating a new warehouse entity
    @PostMapping("/create-warehouse")
    public ResponseEntity<Warehouse> creatWarehouse(Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }

}
