package com.example.Zoomanager.controllers;

import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;
import com.example.Zoomanager.service.interfaceService.TratadorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;




    @ExtendWith(MockitoExtension.class)
    public class TratadorControllerTest {

        @Mock
        private TratadorService tratadorService;

        @InjectMocks
        private TratadorController tratadorController;

        @Test
        void saveTratador_DeveRetornarCreated() {
            TratadorSaveDTO dto = new TratadorSaveDTO();
            Mockito.when(tratadorService.addTratador(dto)).thenReturn("João");

            ResponseEntity<String> response = tratadorController.saveTratador(dto);

            assertEquals(201, response.getStatusCodeValue());
            assertEquals("added João", response.getBody());
        }
    }
