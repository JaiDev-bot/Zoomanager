package com.example.Zoomanager.service.ServiceIMPL;

import com.example.Zoomanager.dto.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;
import com.example.Zoomanager.service.InterfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalServiceIMPL implements AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Override
    public String addAnimal(AnimalSaveDTO animalSaveDTO){

        repository.save(new Animal(
            animalSaveDTO.getName(),
            animalSaveDTO.getIdEspecie(),
            animalSaveDTO.getLastTimeFed()
        ));

        return "";

    }
}
