package com.example.Zoomanager.controllers;


import com.example.Zoomanager.dto.AnimalSaveDTO;
import com.example.Zoomanager.service.InterfaceService.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")

public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping(path = "/save")
    public  String saveAnimal (@RequestBody AnimalSaveDTO animalSaveDTO){

        String name = animalService.addAnimal(animalSaveDTO);
        return "added";
    }


}
