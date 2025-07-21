package com.example.Zoomanager.swagger;

import com.example.Zoomanager.dto.AnimalSaveDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Animais", description = "Gerenciamento de informações sobre os animais do zoológico")
public interface AnimalSwagger {
    
    @Operation(summary = "Adicionar animal", description = "Endpoint para adicionar um novo animal na base de dados")
    String saveAnimal(@RequestBody(
        description = "Informações relacionada ao animal sendo adicionado", 
        content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
        {
            "name": "Leonidas",
            "idEspecie": 1,
            "lastTimeFed": "2025-07-21T12:00:00"
        }
        """))
    ) AnimalSaveDTO animalSaveDTO);

}
