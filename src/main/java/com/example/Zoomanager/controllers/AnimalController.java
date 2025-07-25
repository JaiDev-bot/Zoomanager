package com.example.Zoomanager.controllers;


import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.service.interfaceService.AnimalService;

import com.example.Zoomanager.swagger.AnimalSwagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")

public class AnimalController implements AnimalSwagger {

    private static Logger logger = LoggerFactory.getLogger(AnimalController.class.getName());

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<String> saveAnimal (@RequestBody AnimalSaveDTO animalSaveDTO){

        try{

            String name = animalService.addAnimal(animalSaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(name + " Foi adicionado com sucesso!");

        } catch (Exception e) {

            logger.error("Não foi possivel adicionar o animal. " , e);
            return ResponseEntity.internalServerError().body("Não foi possivel adicionar o animal");

        }
    }


}
