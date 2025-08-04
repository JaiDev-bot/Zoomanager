package com.example.Zoomanager.service.serviceIMPL;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Zoomanager.dto.tarefaDTO.TarefaSaveDTO;
import com.example.Zoomanager.entity.Tarefa;
import com.example.Zoomanager.entity.Tratador;
import com.example.Zoomanager.enums.tarefa.StatusTarefaEnum;
import com.example.Zoomanager.enums.tarefa.TipoTarefaEnum;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.repositories.repositoryInterface.AnimalRepository;
import com.example.Zoomanager.repositories.repositoryInterface.TarefaRepository;
import com.example.Zoomanager.repositories.repositoryInterface.TratadorRepository;
import com.example.Zoomanager.entity.Animal;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceIMPLTest {

    @Mock
    private TarefaRepository repository;

    @Mock
    private AnimalRepository animalRepository;
    
    @Mock
    private TratadorRepository tratadorRepository;

    @InjectMocks
    private TarefaServiceIMPL service;

    @Test
    void addTarefa_Sucesso() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        Tratador mockTratador = mockTratador();
        Tarefa mockTarefa = mockTarefa();
        mockTarefa.setAnimal(mockAnimal);
        mockTarefa.setTratador(mockTratador);

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Mockito.when(tratadorRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockTratador));

        Mockito.when(repository.save(Mockito.any(Tarefa.class)))
            .thenReturn(mockTarefa);

        Assertions.assertDoesNotThrow(() -> service.addTarefa(mockTarefaSaveDTO));
    }

    @Test
    void addTarefa_Falha_AnimalNaoEncontrado() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        mockAnimal.setId(-1L);

        Assertions.assertThrows(BadRequestException.class, () -> service.addTarefa(mockTarefaSaveDTO));
    }
    
    @Test
    void addTarefa_Falha_TratadorNaoEncontrado() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        Tratador mockTratador = mockTratador();
        mockTratador.setId(-1L);

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Assertions.assertThrows(BadRequestException.class, () -> service.addTarefa(mockTarefaSaveDTO));
    }

    @Test
    void addTarefa_Falha_TipoTarefaInvalido() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        Tratador mockTratador = mockTratador();
        mockTarefaSaveDTO.setTipo("");

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));
        
        Mockito.when(tratadorRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockTratador));

        Assertions.assertThrows(BadRequestException.class, () -> service.addTarefa(mockTarefaSaveDTO));
    }

    private TarefaSaveDTO mockTarefaSaveDTO() {
        TarefaSaveDTO alertaSaveDTO = new TarefaSaveDTO();
        alertaSaveDTO.setIdAnimal(1L);
        alertaSaveDTO.setIdTratador(1L);
        alertaSaveDTO.setTipo(TipoTarefaEnum.ALIMENTACAO.toString());
        return alertaSaveDTO;
    }

    private Animal mockAnimal() {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Leão");
        animal.setIdEspecie(1L);
        animal.setLastTimeFed(LocalTime.now());
        return animal;
    }
    
    private Tratador mockTratador() {
        return new Tratador(
            1L, 
            "Jaianêra", 
            false
        );
    }

    private Tarefa mockTarefa() {
        Tarefa alerta = new Tarefa();
        alerta.setId(1L);
        alerta.setTratador(mockTratador());
        alerta.setAnimal(mockAnimal());
        alerta.setStatus(StatusTarefaEnum.ABERTA);
        alerta.setTipo(TipoTarefaEnum.ALIMENTACAO);
        return alerta;
    }

}
