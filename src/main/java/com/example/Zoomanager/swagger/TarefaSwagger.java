package com.example.Zoomanager.swagger;

import org.springframework.http.ResponseEntity;

import com.example.Zoomanager.dto.tarefaDTO.TarefaSaveDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tarefas", description = "Gerenciamento de tarefas relacionados ao tratamento de animais do zoológico")
public interface TarefaSwagger {
    
    @Operation(summary = "Criar nova tarefa", description = "Endpoint para criar uma nova tarefa com relação a um animal para um tratador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso!"),
        @ApiResponse(responseCode = "500", description = "Não foi possível criar a tarefa.")
    })
    ResponseEntity<?> addTarefa(@RequestBody(
        description = "Informações relacionada ao animal, o tratador e o tipo de tarefa em questão", 
        content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
        {
            "idTratador": 0,
            "idAnimal": 0,
            "tipo": "alimentacao"
        }
        """))
    ) TarefaSaveDTO tarefasaveDTO);

}
