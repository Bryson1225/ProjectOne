package com.projectone.projectone.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectone.projectone.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {


    public Optional<Warehouse> findWarehouseByName(String warehouseName);
    public Optional<List<Warehouse>> findWarehouseByLocation(String location);
}
