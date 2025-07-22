package com.example.Zoomanager.service.serviceIMPL;



import com.example.Zoomanager.dto.AlertaSaveDTO;
import com.example.Zoomanager.entity.Alerta;
import com.example.Zoomanager.entity.Animal;
import com.example.Zoomanager.enums.TipoAlerta;
import com.example.Zoomanager.repositories.RepositoryInterface.AlertaRepository;
import com.example.Zoomanager.repositories.RepositoryInterface.AnimalRepository;

import com.example.Zoomanager.service.interfaceService.AlertaService;
import com.example.Zoomanager.utils.EnumUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertaServiceIMPL implements AlertaService {

    @Autowired
    private AlertaRepository repository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void addAlerta(AlertaSaveDTO alertaSaveDTO) {

        Animal animalRef = animalRepository.findById(alertaSaveDTO.getIdAnimal())
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o animal com o id: " + alertaSaveDTO.getIdAnimal()));

        // TODO: Adicionar validação do ID do tratador

        TipoAlerta tipoAlertaVerificado = EnumUtils.getEnumValueFromString(TipoAlerta.class, alertaSaveDTO.getTipo());
        if (tipoAlertaVerificado == null) {
            throw new RuntimeException("Tipo de alerta inválido: " + alertaSaveDTO.getTipo());
        }

        Alerta alerta = new Alerta(
                alertaSaveDTO.getIdTratador(),
                animalRef,
                true, // Por padrão, o alerta começa como aberto
                tipoAlertaVerificado
        );
        repository.save(alerta);
    }
}