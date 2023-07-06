package com.projectone.projectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectone.projectone.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Inventory.InventoryId> {

}
