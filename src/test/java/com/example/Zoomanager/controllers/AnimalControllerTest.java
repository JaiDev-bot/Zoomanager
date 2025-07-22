package com.example.Zoomanager.controllers;



import com.example.Zoomanager.service.interfaceService.AnimalService;
import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalController animalController;

    @Test
    void addAnimal_Sucesso_Created() {
        AnimalSaveDTO mockAnimalSaveDTO = new AnimalSaveDTO();
        Mockito.doNothing().when(animalService).addAnimal(mockAnimalSaveDTO);

        ResponseEntity<?> response = animalController.saveAnimal(mockAnimalSaveDTO);

        Assertions.assertEquals(ResponseEntity.created(null).body("Animal adicionado com sucesso!"), response);
    }

    @Test
    void addAnimal_Falha_InternalServerError() {
        AnimalSaveDTO mockAnimalSaveDTO = new AnimalSaveDTO();
        Mockito.doThrow(RuntimeException.class).when(animalService).addAnimal(mockAnimalSaveDTO);

        ResponseEntity<?> response = animalController.saveAnimal(mockAnimalSaveDTO);

        Assertions.assertEquals(ResponseEntity.internalServerError().body("Não foi possível adicionar o animal."), response);
    }
}
