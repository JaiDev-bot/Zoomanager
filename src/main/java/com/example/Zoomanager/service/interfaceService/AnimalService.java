package com.example.Zoomanager.service.interfaceService;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;

import java.util.List;

public interface AnimalService {

    String addAnimal(AnimalSaveDTO AnimalSaveDto);

    List<AnimalSaveDTO> getAllAnimals();
}


