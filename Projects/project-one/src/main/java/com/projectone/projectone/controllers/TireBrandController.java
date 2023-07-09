package com.projectone.projectone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.services.TireBrandService;

@RestController
@RequestMapping("/tire-brands")
public class TireBrandController {
    
    @Autowired
    TireBrandService tireBrandService;

    /*
     * GET SECTION
     *  - getAll
     */

    @GetMapping
    public ResponseEntity<List<TireBrand>> findAllTireBrands() {
        List<TireBrand> brands = tireBrandService.findAllTireBrands();
        return new ResponseEntity<List<TireBrand>>(brands, HttpStatus.OK);
    }

    @GetMapping("/tire-brand/{brandId}")
    public ResponseEntity<TireBrand> findTireBrandById(@PathVariable int brandId) {
        TireBrand brand = tireBrandService.findTireBrandById(brandId);
        return new ResponseEntity<TireBrand>(brand, HttpStatus.OK);
    }

    @GetMapping("/tire-brand-name/{brandName}")
    public ResponseEntity<TireBrand> findTireBrandByName(@PathVariable String brandName) {
        TireBrand brand = tireBrandService.findTireBrandByName(brandName);
        return new ResponseEntity<TireBrand>(brand, HttpStatus.OK);
    }

    /*
     * ADDING INFORMATION
     *  - Create
     * 
     */

    // Creating a new tirebrand
    @PostMapping("/create-tireBrand")
    public ResponseEntity<TireBrand> createTireBrand(@RequestBody TireBrand tireBrand) {
        System.out.println("WE ARE HERE");
        TireBrand newTireBrand = tireBrandService.createTireBrand(tireBrand);
        return new ResponseEntity<TireBrand>(newTireBrand, HttpStatus.OK);
    }

}
