package com.example.Zoomanager.service.interfaceService;

import com.example.Zoomanager.dto.tratadorDTO.TratadorSaveDTO;

import java.util.List;

public interface TratadorService {

    String addTratador(TratadorSaveDTO tratadorSaveDTO);

    List<TratadorSaveDTO> getAllTratador();
}
