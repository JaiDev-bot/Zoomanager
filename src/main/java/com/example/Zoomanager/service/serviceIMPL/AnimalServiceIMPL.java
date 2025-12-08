package com.example.Zoomanager.service.serviceIMPL;

import com.example.Zoomanager.dto.animalDTO.AnimalSearchDTO;
import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.entity.Especie;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.mappers.AnimalMapper;
import com.example.Zoomanager.repositories.repositoryInterface.AnimalRepository;
import com.example.Zoomanager.repositories.repositoryInterface.EspecieRepository;
import com.example.Zoomanager.service.interfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceIMPL implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private AnimalMapper animalMapper;

    @Override
    public String addAnimal(AnimalSaveDTO animalSaveDTO){

        long idEspecie = animalSaveDTO.getIdEspecie();
        Especie especieRef = especieRepository.findById(idEspecie)
            .orElseThrow(() -> new BadRequestException("Não foi possível encontrar a espécie com o id: " + idEspecie));

        animalRepository.save(new Animal(
            animalSaveDTO.getName(),
            especieRef,
            animalSaveDTO.getLastTimeFed()
        ));

        return "";

    }

    @Override
    public List<AnimalSaveDTO> getAllAnimals () {
        List<Animal> animalEntities = animalRepository.findAll();


        return animalEntities.stream()
                .map(animalMapper::toSaveDTO)
                .toList();
    }
    
    @Override
    public List<AnimalSearchDTO> getHungryAnimals() {

        List<Animal> animalEntities = animalRepository.findHungryAnimals();

        return animalEntities.stream()
                .map(animalMapper::toSearchDTO)
                .toList();
    }
}