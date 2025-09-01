package com.example.Zoomanager.service.serviceIMPL;


import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.repositories.repositoryInterface.AnimalRepository;
import com.example.Zoomanager.service.serviceIMPL.AnimalServiceIMPL;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AnimalServiceIMPLTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalServiceIMPL animalServiceIMPL;

    @Test
    void contextLoads() {
    }

    public AnimalServiceIMPLTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addAnimal_Sucesso() {
        AnimalSaveDTO dto = new AnimalSaveDTO();
        dto.setName("Leão");
        dto.setIdEspecie(1L);
        dto.setLastTimeFed(LocalTime.parse("12:00"));

        when(animalRepository.save(any(Animal.class))).thenReturn(new Animal());

        String result = animalServiceIMPL.addAnimal(dto);

        assertEquals("", result);
        verify(animalRepository, times(1)).save(any(Animal.class));
    }


    @Test
    void addAnimal_Falha() {
        AnimalSaveDTO dto = new AnimalSaveDTO();
        dto.setName("Tigre");
        dto.setIdEspecie(2L);
        dto.setLastTimeFed(LocalTime.parse("2024-06-02"));

        when(animalRepository.save(any(Animal.class))).thenThrow(new RuntimeException("Erro ao salvar"));

        assertThrows(RuntimeException.class, () -> animalServiceIMPL.addAnimal(dto));
        verify(animalRepository, times(1)).save(any(Animal.class));
    }

    @Test
    void getAllAnimals_Sucesso() {
        Animal animal1 = new Animal("Leão", 1L, LocalTime.parse("12:00"));
        Animal animal2 = new Animal("Tigre", 2L, LocalTime.parse("13:00"));
        List<Animal> animalList = List.of(animal1, animal2);

        when(animalRepository.findAll()).thenReturn(animalList);

        List<AnimalSaveDTO> result = animalServiceIMPL.getAllAnimals();

        assertEquals(2, result.size());
        assertEquals("Leão", result.get(0).getName());
        assertEquals("Tigre", result.get(1).getName());
        verify(animalRepository, times(1)).findAll();
    }


    @Test
    void getAllAnimals_Falha() {
        when(animalRepository.findAll()).thenThrow(new RuntimeException("Erro ao buscar animais"));

        assertThrows(RuntimeException.class, () -> animalServiceIMPL.getAllAnimals());
        verify(animalRepository, times(1)).findAll();
    }

    }


