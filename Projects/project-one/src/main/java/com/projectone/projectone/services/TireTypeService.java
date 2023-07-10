package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.repositories.TireTypeRepository;
import java.util.List;
import java.util.Optional;

/*
 * Service class for my tire types
 */

@Service
public class TireTypeService {
    @Autowired
    TireTypeRepository tireTypeRepository;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get all tire types
    public List<TireType> findAllTireTypes() {
        return tireTypeRepository.findAll();
    }

    // Get a tire type with an id
    public TireType findTireTypeById(Integer id) {
        Optional<TireType> tireTypeOptional = tireTypeRepository.findById(id);
        return tireTypeOptional.orElse(null);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Create a new tire type
    public TireType createTireType(TireType tireType) {
        return tireTypeRepository.save(tireType);
    }

    // Update an existing tire type
    public TireType updateTireType(Integer id, TireType tireType) {
        Optional<TireType> tireTypeOptional = tireTypeRepository.findById(id);
        if (tireTypeOptional.isPresent()) {
            TireType existingTireType = tireTypeOptional.get();
            existingTireType.setTireTypeName(tireType.getTireTypeName());
            existingTireType.setDescription(tireType.getDescription());
            existingTireType.setPrice(tireType.getPrice());
            existingTireType.setTireBrand(tireType.getTireBrand());
            return tireTypeRepository.save(existingTireType);
        } else {
            return null;
        }
    }

    // Delete an existing tire type
    public boolean deleteTireType(Integer id) {
        if (tireTypeRepository.existsById(id)) {
            tireTypeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

