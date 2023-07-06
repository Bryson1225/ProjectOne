package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }
/*
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Inventory.InventoryId id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public void deleteInventory(Inventory.InventoryId id) {
        inventoryRepository.deleteById(id);
    }
    */
}

