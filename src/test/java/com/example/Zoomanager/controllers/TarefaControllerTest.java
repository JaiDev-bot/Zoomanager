package com.example.Zoomanager.controllers;

import com.example.Zoomanager.dto.tarefaDTO.TarefaSaveDTO;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.service.interfaceService.TarefaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class TarefaControllerTest {

    @Mock
    private TarefaService tarefaService;
    
    @InjectMocks
    private TarefaController tarefaController;

    @Test
    void addTarefa_Sucesso_Created() {

        TarefaSaveDTO mockAlertaSaveDTO = new TarefaSaveDTO();

        Mockito.doNothing().when(tarefaService).addTarefa(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = tarefaController.addTarefa(mockAlertaSaveDTO);
        
        Assertions.assertEquals(ResponseEntity.created(null).body("Tarefa criada com sucesso!"), response);
    }
    
    @Test
    void addTarefa_Falha_InternalServerError() {

        TarefaSaveDTO mockAlertaSaveDTO = new TarefaSaveDTO();

        Mockito.doThrow(RuntimeException.class)
            .when(tarefaService)
            .addTarefa(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = tarefaController.addTarefa(mockAlertaSaveDTO);
        
        Assertions.assertEquals(ResponseEntity.internalServerError().body("Não foi possível criar a tarefa."), response);
    }
    
    @Test
    void addTarefa_Falha_BadRequest() {

        TarefaSaveDTO mockAlertaSaveDTO = new TarefaSaveDTO();

        Mockito.doThrow(BadRequestException.class)
            .when(tarefaService)
            .addTarefa(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = tarefaController.addTarefa(mockAlertaSaveDTO);
        
        Assertions.assertEquals(ResponseEntity.badRequest().body("Não foi possível criar a tarefa:\nnull"), response);
    }

}
