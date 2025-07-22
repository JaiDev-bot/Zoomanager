package com.example.Zoomanager.swagger;

import org.springframework.http.ResponseEntity;

import com.example.Zoomanager.dto.AlertaSaveDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alertas", description = "Gerenciamento de alertas relacionados aos animais do zoológico")
public interface AlertaSwagger {
    
    @Operation(summary = "Abrir novo alerta", description = "Endpoint para abrir um novo alerta com relação a um animal para um tratador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alerta adicionado com sucesso!"),
        @ApiResponse(responseCode = "500", description = "Não foi possível adicionar o alerta.")
    })
    ResponseEntity<?> addAlerta(@RequestBody(
        description = "Informações relacionada ao animal, o tratador e o tipo de alerta em questão", 
        content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
        {
            "idTratador": 0,
            "idAnimal": 0,
            "tipo": "alimentacao"
        }
        """))
    ) AlertaSaveDTO alertaSaveDTO);

}
