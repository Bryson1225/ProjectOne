package com.projectone.projectone.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectone.projectone.models.TireBrand;

@Repository
public interface TireBrandRepository extends JpaRepository<TireBrand, Integer> {

    public Optional<TireBrand> findBybrandName(String brandName);
}
