package com.projectone.projectone.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectone.projectone.models.Inventory;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.models.Warehouse;

/*
 * This is the repository class for my Inventory
 */

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Inventory.InventoryId> {
    List<Inventory> findByWarehouseId(Warehouse warehouseId);
    List<Inventory> findByTireTypeId(TireType tireTypeId);
    Inventory findByWarehouseIdAndTireTypeId(Warehouse warehouseId, TireType tireTypeId);
    List<Inventory> findByQuantityGreaterThan(Integer quantity);
    List<Inventory> findByQuantityLessThan(Integer quantity);
}
