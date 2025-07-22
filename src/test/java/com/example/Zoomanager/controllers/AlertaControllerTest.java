package com.example.Zoomanager.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.Zoomanager.dto.AlertaSaveDTO;
import com.example.Zoomanager.service.InterfaceService.AlertaService;

@ExtendWith(MockitoExtension.class)
public class AlertaControllerTest {

    @Mock
    private AlertaService alertaService;
    
    @InjectMocks
    private AlertaController alertaController;

    @Test
    void addAlerta_Sucesso_Created() {

        AlertaSaveDTO mockAlertaSaveDTO = new AlertaSaveDTO();

        Mockito.doNothing().when(alertaService).addAlerta(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = alertaController.addAlerta(mockAlertaSaveDTO);
        
        Assertions.assertEquals(ResponseEntity.created(null).body("Alerta adicionado com sucesso!"), response);
    }
    
    @Test
    void addAlerta_Falha_InternalServerError() {

        AlertaSaveDTO mockAlertaSaveDTO = new AlertaSaveDTO();

        Mockito.doThrow(RuntimeException.class)
            .when(alertaService)
            .addAlerta(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = alertaController.addAlerta(mockAlertaSaveDTO);
        
        Assertions.assertEquals(ResponseEntity.internalServerError().body("Não foi possível adicionar o alerta."), response);
    }

}
