package com.example.Zoomanager.mappers;

import com.example.Zoomanager.dto.animalDTO.AnimalSearchDTO;

import org.springframework.stereotype.Service;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;

@Service
public class AnimalMapper {

    public AnimalSearchDTO toSearchDTO(Animal animal) {
        return new AnimalSearchDTO(
            animal.getId(), 
            animal.getName(), 
            animal.getEspecie().getId(), 
            animal.getLastTimeFed()
        );
    }

    public AnimalSaveDTO toSaveDTO(Animal animal) {
        return new AnimalSaveDTO(
            animal.getName(), 
            animal.getEspecie().getId(), 
            animal.getLastTimeFed()
        );
    }
    
}
