package com.projectone.projectone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.TireBrand;
import com.projectone.projectone.services.TireBrandService;

@RestController
@RequestMapping("/tire-brands")
public class TireBrandController {
    
    

    @Autowired
    TireBrandService brandService;

    @GetMapping
    public ResponseEntity<List<TireBrand>> findAllWarehouses() {
        List<TireBrand> brands = brandService.findAllBrands();
        return new ResponseEntity<List<TireBrand>>(brands, HttpStatus.OK);
    }

}
