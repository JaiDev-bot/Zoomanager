package com.example.Zoomanager.service.interfaceService;

import java.util.List;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.dto.animalDTO.AnimalSearchDTO;

public interface AnimalService {

    String addAnimal(AnimalSaveDTO AnimalSaveDto);

    List<AnimalSaveDTO> getAllAnimals();

    List<AnimalSearchDTO> getHungryAnimals();
}


