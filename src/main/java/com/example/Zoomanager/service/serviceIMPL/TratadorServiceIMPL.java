package com.example.Zoomanager.service.serviceIMPL;

import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;
import com.example.Zoomanager.entity.Tratador;
import com.example.Zoomanager.repositories.RepositoryInterface.TratadorRepository;
import com.example.Zoomanager.service.interfaceService.TratadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TratadorServiceIMPL implements TratadorService {

    @Autowired
    private TratadorRepository tratadorRepository;

    @Override
    public String addTratador(TratadorSaveDTO tratadorSaveDTO){
        tratadorRepository.save(new Tratador(
                tratadorSaveDTO.id(),
               tratadorSaveDTO.name(),
                tratadorSaveDTO.ocupado()
        ));

        return "";
    }


}

