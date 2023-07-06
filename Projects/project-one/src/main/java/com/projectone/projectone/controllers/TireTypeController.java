package com.projectone.projectone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectone.projectone.models.TireType;
import com.projectone.projectone.services.TireTypeService;

@RestController
@RequestMapping("/tire-types")
public class TireTypeController {
    
    @Autowired
    TireTypeService typeService;

    @GetMapping
    public ResponseEntity<List<TireType>> findAllWarehouses() {
        List<TireType> types = typeService.findAllTireTypes();
        return new ResponseEntity<List<TireType>>(types, HttpStatus.OK);
    }

}
