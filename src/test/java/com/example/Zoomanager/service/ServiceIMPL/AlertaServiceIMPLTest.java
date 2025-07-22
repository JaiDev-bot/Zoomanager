package com.example.Zoomanager.service.ServiceIMPL;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Zoomanager.dto.AlertaSaveDTO;
import com.example.Zoomanager.entity.Alerta;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.enums.TipoAlerta;
import com.example.Zoomanager.repositories.RepositoryInterface.AlertaRepository;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;

@ExtendWith(MockitoExtension.class)
public class AlertaServiceIMPLTest {

    @Mock
    private AlertaRepository repository;

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AlertaServiceIMPL alertaServiceIMPL;

    @Test
    void addAlerta_Sucesso() {
        AlertaSaveDTO mockAlertaSaveDTO = mockAlertaSaveDTO();
        Animal mockAnimal = mockAnimal();
        Alerta mockAlerta = mockAlerta();
        mockAlerta.setAnimal(mockAnimal);

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Mockito.when(repository.save(Mockito.any(Alerta.class)))
            .thenReturn(mockAlerta);

        Assertions.assertDoesNotThrow(() -> alertaServiceIMPL.addAlerta(mockAlertaSaveDTO));
    }

    @Test
    void addAlerta_Falha_AnimalNaoEncontrado() {
        AlertaSaveDTO mockAlertaSaveDTO = mockAlertaSaveDTO();
        Animal mockAnimal = mockAnimal();
        mockAlertaSaveDTO.setTipo("");

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(mockAnimal));

        Assertions.assertThrows(RuntimeException.class, () -> alertaServiceIMPL.addAlerta(mockAlertaSaveDTO));
    }

    @Test
    void addAlerta_Falha_TipoAlertaInvalido() {
        AlertaSaveDTO mockAlertaSaveDTO = mockAlertaSaveDTO();

        Mockito.when(animalRepository.findById(Mockito.anyLong()))
            .thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> alertaServiceIMPL.addAlerta(mockAlertaSaveDTO));
    }

    private AlertaSaveDTO mockAlertaSaveDTO() {
        AlertaSaveDTO alertaSaveDTO = new AlertaSaveDTO();
        alertaSaveDTO.setIdAnimal(1L);
        alertaSaveDTO.setIdTratador(1L);
        alertaSaveDTO.setTipo(TipoAlerta.ALIMENTACAO.toString());
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

    private Alerta mockAlerta() {
        Alerta alerta = new Alerta();
        alerta.setId(1L);
        alerta.setIdTratador(1L);
        alerta.setAnimal(mockAnimal());
        alerta.setAberto(true);
        alerta.setTipo(TipoAlerta.ALIMENTACAO);
        return alerta;
    }

}
