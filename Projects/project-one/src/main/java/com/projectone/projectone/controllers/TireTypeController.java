package com.projectone.projectone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.models.TireType;
import com.projectone.projectone.services.TireTypeService;

// Controller class for my tire types

@RestController
@RequestMapping("/tire-types")
@CrossOrigin
public class TireTypeController {
    
    @Autowired
    TireTypeService tireTypeService;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get all tire types
    @GetMapping
    public ResponseEntity<List<TireType>> findAllTireTypes() {
        List<TireType> types = tireTypeService.findAllTireTypes();
        return new ResponseEntity<List<TireType>>(types, HttpStatus.OK);
    }

    // Get a tire type with its id
    @GetMapping("/tire-type/{id}")
    public ResponseEntity<TireType> getTireTypeById(@PathVariable Integer id) {
        TireType tireType = tireTypeService.findTireTypeById(id);
        if (tireType != null) {
            return new ResponseEntity<>(tireType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all tire types for a specific brand
    @GetMapping("/tire-brand/{tireBrand}")
    public ResponseEntity<List<TireType>> findTireTypesByBrand(@PathVariable TireBrand tireBrand) {
        List<TireType> types = tireTypeService.findTireTypesByBrand(tireBrand);
        return new ResponseEntity<List<TireType>>(types, HttpStatus.OK);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Create a new tire type
    @PostMapping
    public ResponseEntity<TireType> createTireType(@RequestBody TireType tireType) {
        TireType createdTireType = tireTypeService.createTireType(tireType);
        return new ResponseEntity<>(createdTireType, HttpStatus.CREATED);
    }

    // Change an existing tire type
    @PutMapping("/{id}")
    public ResponseEntity<TireType> updateTireType(@PathVariable Integer id, @RequestBody TireType tireType) {
        TireType updatedTireType = tireTypeService.updateTireType(id, tireType);
        if (updatedTireType != null) {
            return new ResponseEntity<>(updatedTireType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a tire type with an id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTireType(@PathVariable Integer id) {
        boolean deleted = tireTypeService.deleteTireType(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
