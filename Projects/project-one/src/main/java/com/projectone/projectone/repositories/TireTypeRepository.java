package com.projectone.projectone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.models.TireType;

/*
 * This is the repository class for my tire types
 */

@Repository
public interface TireTypeRepository extends JpaRepository<TireType, Integer> {

    List<TireType> findByTireBrand(TireBrand tireBrand);
}
