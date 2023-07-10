package com.projectone.projectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectone.projectone.models.TireType;

/*
 * This is the repository class for my tire types
 */

@Repository
public interface TireTypeRepository extends JpaRepository<TireType, Integer> {

}
