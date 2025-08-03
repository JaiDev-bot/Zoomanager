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
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.enums.TipoTarefa;
import com.example.Zoomanager.repositories.RepositoryInterface.TarefaRepository;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceIMPLTest {

    @Mock
    private TarefaRepository repository;

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private TarefaServiceIMPL service;

    @Test
    void addTarefa_Sucesso() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        Tarefa mockTarefa = mockTarefa();
        mockTarefa.setAnimal(mockAnimal);

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Mockito.when(repository.save(Mockito.any(Tarefa.class)))
            .thenReturn(mockTarefa);

        Assertions.assertDoesNotThrow(() -> service.addTarefa(mockTarefaSaveDTO));
    }

    @Test
    void addTarefa_Falha_AnimalNaoEncontrado() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();
        Animal mockAnimal = mockAnimal();
        mockTarefaSaveDTO.setTipo("");

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Assertions.assertThrows(RuntimeException.class, () -> service.addTarefa(mockTarefaSaveDTO));
    }

    @Test
    void addTarefa_Falha_TipoTarefaInvalido() {
        TarefaSaveDTO mockTarefaSaveDTO = mockTarefaSaveDTO();

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> service.addTarefa(mockTarefaSaveDTO));
    }

    private TarefaSaveDTO mockTarefaSaveDTO() {
        TarefaSaveDTO alertaSaveDTO = new TarefaSaveDTO();
        alertaSaveDTO.setIdAnimal(1L);
        alertaSaveDTO.setIdTratador(1L);
        alertaSaveDTO.setTipo(TipoTarefa.ALIMENTACAO.toString());
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

    private Tarefa mockTarefa() {
        Tarefa alerta = new Tarefa();
        alerta.setId(1L);
        alerta.setIdTratador(1L);
        alerta.setAnimal(mockAnimal());
        alerta.setAberto(true);
        alerta.setTipo(TipoTarefa.ALIMENTACAO);
        return alerta;
    }

}
