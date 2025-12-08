package com.example.Zoomanager.service.serviceIMPL;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.dto.animalDTO.AnimalSearchDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.entity.Especie;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.mappers.AnimalMapper;
import com.example.Zoomanager.repositories.repositoryInterface.AnimalRepository;
import com.example.Zoomanager.repositories.repositoryInterface.EspecieRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnimalServiceIMPLTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private EspecieRepository especieRepository;

    @Mock
    private AnimalMapper animalMapper;

    @InjectMocks
    private AnimalServiceIMPL animalServiceIMPL;

    @Test
    void addAnimal_Falha_AnimalNaoEncontrado(){

        // Arrange
        AnimalSaveDTO mockAnimalSaveDTO = mockAnimalSaveDTO();

        when(especieRepository.findById(anyLong()))
            .thenReturn(Optional.ofNullable(null));

        // Act e Assert
        assertThrows(BadRequestException.class, () -> {
            animalServiceIMPL.addAnimal(mockAnimalSaveDTO);
        });
    }

    @Test
    void addAnimal_Sucesso() {

        // Arrange
        AnimalSaveDTO mockAnimalSaveDTO = mockAnimalSaveDTO();
        Especie mockEspecie = mock(Especie.class);
        Animal mockAnimal = mock(Animal.class);

        when(especieRepository.findById(anyLong()))
            .thenReturn(Optional.of(mockEspecie));

        when(animalRepository.save(any()))
            .thenReturn(mockAnimal);

        // Act e Assert
        assertDoesNotThrow(() -> {
            animalServiceIMPL.addAnimal(mockAnimalSaveDTO);
        });
    }

    @Test
    void addAnimal_Falha() {

        AnimalSaveDTO dto = new AnimalSaveDTO();
        dto.setName("Tigre");
        dto.setIdEspecie(2L);
        dto.setLastTimeFed(LocalDateTime.now());
        Especie mockEspecie = mock(Especie.class);
        
        when(especieRepository.findById(anyLong())).thenReturn(Optional.of(mockEspecie));
        when(animalRepository.save(any(Animal.class))).thenThrow(new RuntimeException("Erro ao salvar"));

        assertThrows(RuntimeException.class, () -> animalServiceIMPL.addAnimal(dto));
        verify(animalRepository, times(1)).save(any(Animal.class));
    }

    @Test
    void getAllAnimals_Sucesso() {

        // Arrange
        Animal mockAnimal = mock(Animal.class);
        AnimalSaveDTO mockAnimalSaveDTO = mock(AnimalSaveDTO.class);

        when(animalRepository.findAll())
            .thenReturn(List.of(mockAnimal));
        when(animalMapper.toSaveDTO(any()))
            .thenReturn(mockAnimalSaveDTO);
    
        // Act e Assert
        assertDoesNotThrow(() -> {
            animalServiceIMPL.getAllAnimals();
        });
    }

    @Test
    void getAllAnimals_Falha() {
        when(animalRepository.findAll()).thenThrow(new RuntimeException("Erro ao buscar animais"));

        assertThrows(RuntimeException.class, () -> animalServiceIMPL.getAllAnimals());
        verify(animalRepository, times(1)).findAll();
    }


    @Test
    void getHungryAnimals_Sucesso() {

        // Arrange
        Animal mockAnimal = mock(Animal.class);
        AnimalSearchDTO mockAnimalSearchDTO = mock(AnimalSearchDTO.class);

        when(animalRepository.findHungryAnimals())
            .thenReturn(List.of(mockAnimal));

        when(animalMapper.toSearchDTO(any()))
            .thenReturn(mockAnimalSearchDTO);

        // Act e Assert
        assertDoesNotThrow(() -> {
            animalServiceIMPL.getHungryAnimals();
        });
    }

    private AnimalSaveDTO mockAnimalSaveDTO() {
        AnimalSaveDTO animalSaveDTO = new AnimalSaveDTO();
        animalSaveDTO.setName("Leão");
        animalSaveDTO.setIdEspecie(1L);
        animalSaveDTO.setLastTimeFed(LocalDateTime.now());
        return animalSaveDTO;
    }
}


