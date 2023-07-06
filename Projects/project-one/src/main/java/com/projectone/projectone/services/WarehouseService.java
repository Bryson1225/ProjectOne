package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectone.projectone.models.Warehouse;
import com.projectone.projectone.repositories.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    //private final WarehouseRepository warehouseRepository;

    //@Autowired
    //public WarehouseService(WarehouseRepository warehouseRepository) {
    //    this.warehouseRepository = warehouseRepository;
    //}

    //public Warehouse saveWarehouse(Warehouse warehouse) {
    //    return warehouseRepository.save(warehouse);
    //}

    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }

    //public Warehouse getWarehouseById(Long id) {
    //    return warehouseRepository.findById(id).orElse(null);
    //}

    //public void deleteWarehouse(Long id) {
    //    warehouseRepository.deleteById(id);
    //}
}

