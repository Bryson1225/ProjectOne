package com.projectone.projectone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    

    @Autowired
    InventoryService typeService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getInventory() {
        List<Inventory> inventory = typeService.getInventory();
        return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

}
