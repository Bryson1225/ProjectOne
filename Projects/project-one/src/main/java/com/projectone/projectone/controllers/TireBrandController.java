package com.projectone.projectone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.services.TireBrandService;

// Controller class for my tire brands

@RestController
@RequestMapping("/tire-brands")
public class TireBrandController {
    
    @Autowired
    TireBrandService tireBrandService;

     ////////////////////////////
    // **** GET REQUESTS **** //
   ////////////////////////////

    // Get all tire brandss
    @GetMapping
    public ResponseEntity<List<TireBrand>> findAllTireBrands() {
        List<TireBrand> brands = tireBrandService.findAllTireBrands();
        return new ResponseEntity<List<TireBrand>>(brands, HttpStatus.OK);
    }

    // Get a tire brand with an id
    @GetMapping("/tire-brand/{brandId}")
    public ResponseEntity<TireBrand> findTireBrandById(@PathVariable int brandId) {
        TireBrand brand = tireBrandService.findTireBrandById(brandId);
        return new ResponseEntity<TireBrand>(brand, HttpStatus.OK);
    }

    // Get a tire brand with its name
    @GetMapping("/tire-brand-name/{brandName}")
    public ResponseEntity<TireBrand> findTireBrandByName(@PathVariable String brandName) {
        TireBrand brand = tireBrandService.findTireBrandByName(brandName);
        return new ResponseEntity<TireBrand>(brand, HttpStatus.OK);
    }

     //////////////////////////////////
    // **** MODIFYINH REQUESTS **** //
   //////////////////////////////////

    // Create a new tire brand
     @PostMapping("/create-tireBrand")
     public ResponseEntity<TireBrand> createTireBrand(@RequestBody TireBrand tireBrand) {
         TireBrand newTireBrand = tireBrandService.createTireBrand(tireBrand);
         return new ResponseEntity<>(newTireBrand, HttpStatus.OK);
     }

    // Update an existing tire brand
    @PutMapping("/update-tireBrand/{brandId}")
    public ResponseEntity<TireBrand> updateTireBrand(@PathVariable int brandId, @RequestBody TireBrand updatedTireBrand) {
        TireBrand brand = tireBrandService.findTireBrandById(brandId);
        if (brand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        brand.setBrandName(updatedTireBrand.getBrandName());
        TireBrand updatedBrand = tireBrandService.updateTireBrand(brand);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    // Delete a tire brand by ID
    @DeleteMapping("/delete-tireBrand/{brandId}")
    public ResponseEntity<Void> deleteTireBrand(@PathVariable int brandId) {
        TireBrand brand = tireBrandService.findTireBrandById(brandId);
        if (brand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tireBrandService.deleteTireBrand(brand);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
