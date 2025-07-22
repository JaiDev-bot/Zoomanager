package com.example.Zoomanager.controllers;


import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.service.interfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")

public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public  ResponseEntity<String> saveAnimal (@RequestBody AnimalSaveDTO animalSaveDTO){
        String name = animalService.addAnimal(animalSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("added " + name);
    }


}
