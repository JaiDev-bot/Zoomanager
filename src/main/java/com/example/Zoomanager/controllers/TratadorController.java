package com.example.Zoomanager.controllers;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;
import com.example.Zoomanager.service.interfaceService.TratadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/cuidador")
public class TratadorController {

    private Logger logger = LoggerFactory.getLogger(TratadorController.class.getName());


    @Autowired
    private TratadorService tratadorService;

    @PostMapping
    public ResponseEntity<String> saveTratador(@RequestBody TratadorSaveDTO tratadorSaveDTO) {

        try {
            String name = tratadorService.addTratador(tratadorSaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(name + " foi adicionado com sucesso!");

        } catch (Exception e) {

         logger.error("Não foi possivel adcionar o Tratador. ", e);
         return ResponseEntity.internalServerError().body(" Não foi possivel adicionar o tratador. ");

        }

    }

}