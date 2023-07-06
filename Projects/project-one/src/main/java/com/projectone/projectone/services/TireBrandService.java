package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.repositories.TireBrandRepository;

import java.util.List;

@Service
public class TireBrandService {
    @Autowired
    TireBrandRepository tireBrandRepository;

        public List<TireBrand> findAllBrands() {
        return tireBrandRepository.findAll();
    }
/*
    @Autowired
    public TireBrandService(TireBrandRepository tireBrandRepository) {
        this.tireBrandRepository = tireBrandRepository;
    }

    public TireBrand saveTireBrand(TireBrand tireBrand) {
        return tireBrandRepository.save(tireBrand);
    }

    public List<TireBrand> getAllTireBrands() {
        return tireBrandRepository.findAll();
    }

    public TireBrand getTireBrandById(Long id) {
        return tireBrandRepository.findById(id).orElse(null);
    }

    public void deleteTireBrand(Long id) {
        tireBrandRepository.deleteById(id);
    }
    */
}

