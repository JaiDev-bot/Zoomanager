package com.example.Zoomanager.service.ServiceIMPL;

import com.example.Zoomanager.dto.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.service.InterfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalServiceIMPL implements AnimalService {


    @Autowired AnimalService AnimalService;

    @Override
    public  String addAnimal(AnimalSaveDTO animalSaveDTO){

        Animal animal = new Animal(

                animalSaveDTO.getName(),
                animalSaveDTO.getIdEspecie(),
                animalSaveDTO.getLastTimeFed()

        );

        return "";

    }



}
