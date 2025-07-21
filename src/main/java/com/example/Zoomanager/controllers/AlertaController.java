package com.example.Zoomanager.controllers;

import com.example.Zoomanager.dto.AlertaSaveDTO;
import com.example.Zoomanager.service.InterfaceService.AlertaService;
import com.example.Zoomanager.swagger.AlertaSwagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerta")
public class AlertaController implements AlertaSwagger {

    @Autowired
    private AlertaService alertaService;

    @PostMapping
    public ResponseEntity<?> addAlerta(@RequestBody AlertaSaveDTO alertaSaveDTO) {

        try{
            alertaService.addAlerta(alertaSaveDTO);
            return ResponseEntity.created(null).body("Alerta adicionado com sucesso!");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível adicionar o alerta.");
        }
    }
}