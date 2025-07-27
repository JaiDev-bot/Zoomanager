package com.example.Zoomanager.service.serviceIMPL;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;
import com.example.Zoomanager.service.interfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

        @Override
        public List<AnimalSaveDTO> getAllAnimals () {
            List<Animal> animalEntities = repository.findAll();


            return animalEntities.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }


        private AnimalSaveDTO convertToDto(Animal animal) {
            AnimalSaveDTO dto = new AnimalSaveDTO();

            dto.setName(animal.getName());
            dto.setIdEspecie(animal.getIdEspecie());
            dto.setLastTimeFed(animal.getLastTimeFed());

            return dto;
        }

    }