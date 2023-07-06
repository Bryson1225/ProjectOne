package com.projectone.projectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectone.projectone.models.TireBrand;

@Repository
public interface TireBrandRepository extends JpaRepository<TireBrand, Long> {

}
