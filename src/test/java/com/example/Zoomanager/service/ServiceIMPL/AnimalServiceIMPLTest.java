package com.example.Zoomanager.service.ServiceIMPL;

import com.example.Zoomanager.dto.animalDTO.AnimalSaveDTO;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;
import com.example.Zoomanager.service.serviceIMPL.AnimalServiceIMPL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AnimalServiceIMPLTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalServiceIMPL animalServiceIMPL;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }



    @Test
    void addAnimal_AnimalNaoEncontrado(){



    }

}
