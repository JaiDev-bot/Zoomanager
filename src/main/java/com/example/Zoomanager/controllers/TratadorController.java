package com.example.Zoomanager.controllers;


import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;
import com.example.Zoomanager.service.interfaceService.TratadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cuidador")
public class TratadorController {

    @Autowired
    TratadorService tratadorService;

    @PostMapping
    public ResponseEntity<String> saveTratador (@RequestBody TratadorSaveDTO tratadorSaveDTO){
        String name = tratadorService.addTratador(tratadorSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("added " + name);

    }

}
