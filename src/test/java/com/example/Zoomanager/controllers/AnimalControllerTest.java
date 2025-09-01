package com.example.Zoomanager.controllers;



import com.example.Zoomanager.service.interfaceService.AnimalService;
import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }


    @Test

    void saveAnimal_DeveRetornarCreated_ComMensagemDeSucesso() {
        AnimalSaveDTO mockAnimalSaveDTO = new AnimalSaveDTO();
        Mockito.when(animalService.addAnimal(Mockito.any(AnimalSaveDTO.class))).thenReturn("Leão");

        ResponseEntity<String> response = animalController.saveAnimal(mockAnimalSaveDTO);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Leão Foi adicionado com sucesso!", response.getBody());
    }

    @Test
    void saveAnimal_DeveRetornarInternalServerError_EmCasoDeFalha() {
        AnimalSaveDTO mockAnimalSaveDTO = new AnimalSaveDTO();
        Mockito.doThrow(new RuntimeException("Erro")).when(animalService).addAnimal(Mockito.any(AnimalSaveDTO.class));

        ResponseEntity<String> response = animalController.saveAnimal(mockAnimalSaveDTO);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("Não foi possivel adicionar o animal.", response.getBody());
    }

    @Test
    void getAnimals_DeveRetornarNoContent_QuandoListaVazia() {
        Mockito.when(animalService.getAllAnimals()).thenReturn(List.of());

        ResponseEntity<List<AnimalSaveDTO>> response = animalController.getAnimals();

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void getAnimals_DeveRetornarInternalServerError_EmCasoDeErro() {
        Mockito.when(animalService.getAllAnimals()).thenThrow(new RuntimeException("Erro"));

        ResponseEntity<List<AnimalSaveDTO>> response = animalController.getAnimals();

        assertEquals(500, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
