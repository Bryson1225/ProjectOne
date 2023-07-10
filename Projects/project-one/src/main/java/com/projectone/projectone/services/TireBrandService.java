package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.repositories.TireBrandRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TireBrandService {
    @Autowired
    TireBrandRepository tireBrandRepository;

    /*
     * GET REQUESTS
     *  - All
     */

    // Return a list of all tire brands currently in the DB
    public List<TireBrand> findAllTireBrands() {
        return tireBrandRepository.findAll();
    }

    // Returns a singular tireBrand given an Id
    public TireBrand findTireBrandById(int brandId) {
        Optional<TireBrand> tireBrand = tireBrandRepository.findById(brandId);
        if (tireBrand.isPresent()) {
            return tireBrand.get();
        }
        return null;
    }

    // Returns a singular tireBrand given a name
    public TireBrand findTireBrandByName(String brandName) {
        Optional<TireBrand> tireBrand = tireBrandRepository.findBybrandName(brandName);
        if (tireBrand.isPresent()) {
            return tireBrand.get();
        }
        return null;
    }

    /*
     * ADDING INFORMATION
     *  - Create
     * 
     * 
     */

     public TireBrand createTireBrand(TireBrand tireBrand) {
        return tireBrandRepository.save(tireBrand);
     }

     public TireBrand updateTireBrand(TireBrand tireBrand) {
        return tireBrandRepository.save(tireBrand);
    }

        // Delete a tire brand
    public void deleteTireBrand(TireBrand tireBrand) {
        tireBrandRepository.delete(tireBrand);
    }
}

