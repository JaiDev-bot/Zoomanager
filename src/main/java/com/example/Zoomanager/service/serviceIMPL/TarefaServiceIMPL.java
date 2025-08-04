package com.example.Zoomanager.service.serviceIMPL;

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
import com.example.Zoomanager.service.interfaceService.TarefaService;
import com.example.Zoomanager.utils.EnumUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceIMPL implements TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private TratadorRepository tratadorRepository;

    @Override
    public void addTarefa(TarefaSaveDTO tarefaSaveDTO) {

        long idAnimal = tarefaSaveDTO.getIdAnimal();
        Animal animalRef = animalRepository.findById(idAnimal)
            .orElseThrow(() -> new BadRequestException("Não foi possível encontrar o animal com o id: " + idAnimal));
        
        long idTratador = tarefaSaveDTO.getIdTratador();
        Tratador tratadorRef = tratadorRepository.findById(idTratador)
                .orElseThrow(() -> new BadRequestException("Não foi possível encontrar o tratador com o id: " + idTratador));

        TipoTarefaEnum tipoTarefaVerificado = EnumUtils.getEnumValueFromString(TipoTarefaEnum.class, tarefaSaveDTO.getTipo());
        if (tipoTarefaVerificado == null) {
            throw new BadRequestException("Tipo de tarefa inválido: " + tarefaSaveDTO.getTipo());
        }

        Tarefa alerta = new Tarefa(
                tratadorRef,
                animalRef,
                StatusTarefaEnum.ABERTA, // Por padrão, a tarefa começa como aberta
                tipoTarefaVerificado
        );
        repository.save(alerta);
    }
}