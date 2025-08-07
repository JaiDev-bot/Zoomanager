package com.example.Zoomanager.service.serviceIMPL;

import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;
import com.example.Zoomanager.entity.Tratador;
import com.example.Zoomanager.repositories.RepositoryInterface.TratadorRepository;
import com.example.Zoomanager.service.interfaceService.TratadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TratadorServiceIMPL implements TratadorService {

    @Autowired
    private TratadorRepository tratadorRepository;

    @Override
    public String addTratador(TratadorSaveDTO tratadorSaveDTO){
        tratadorRepository.save(new Tratador(
                tratadorSaveDTO.getId(),
               tratadorSaveDTO.getName(),
                tratadorSaveDTO.getOcupado()
        ));

        return "";
    }

    @Override
    public List<TratadorSaveDTO> getAllTratador(){
        List<Tratador> tratadorEntities = tratadorRepository.findAll();

        return tratadorEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TratadorSaveDTO convertToDto(Tratador tratador) {
       TratadorSaveDTO dto = new TratadorSaveDTO();

       dto.setId(tratador.getId());
        dto.setName(tratador.getName());
        dto.setOcupado(tratador.getOcupado());

        return dto;
    }


}

