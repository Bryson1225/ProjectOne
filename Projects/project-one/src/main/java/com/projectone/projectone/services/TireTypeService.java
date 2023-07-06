package com.projectone.projectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectone.projectone.models.TireType;
import com.projectone.projectone.repositories.TireTypeRepository;

import java.util.List;

@Service
public class TireTypeService {
    @Autowired
    TireTypeRepository tireTypeRepository;

    public List<TireType> findAllTireTypes() {
        return tireTypeRepository.findAll();
    }
/*
    @Autowired
    public TireTypeService(TireTypeRepository tireTypeRepository) {
        this.tireTypeRepository = tireTypeRepository;
    }

    public TireType saveTireType(TireType tireType) {
        return tireTypeRepository.save(tireType);
    }

    public List<TireType> getAllTireTypes() {
        return tireTypeRepository.findAll();
    }

    public TireType getTireTypeById(Long id) {
        return tireTypeRepository.findById(id).orElse(null);
    }

    public void deleteTireType(Long id) {
        tireTypeRepository.deleteById(id);
    }
    */
}

