package com.example.Zoomanager.controllers;

import com.example.Zoomanager.dto.tarefaDTO.TarefaSaveDTO;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.service.interfaceService.TarefaService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
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
        
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("Tarefa criada com sucesso!", response.getBody());
    }
    
    @Test
    void addTarefa_Falha_InternalServerError() {

        TarefaSaveDTO mockAlertaSaveDTO = new TarefaSaveDTO();

        Mockito.doThrow(RuntimeException.class)
            .when(tarefaService)
            .addTarefa(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = tarefaController.addTarefa(mockAlertaSaveDTO);
        
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Assertions.assertEquals("Não foi possível criar a tarefa.", response.getBody());
    }
    
    @Test
    void addTarefa_Falha_BadRequest() {

        TarefaSaveDTO mockAlertaSaveDTO = new TarefaSaveDTO();

        Mockito.doThrow(BadRequestException.class)
            .when(tarefaService)
            .addTarefa(mockAlertaSaveDTO);
            
        ResponseEntity<?> response = tarefaController.addTarefa(mockAlertaSaveDTO);
        
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals("Não foi possível criar a tarefa:\nnull", response.getBody());
    }

    @Test
    void iniciarExecucaoTarefa_Sucesso() {
        
        Long tarefaId = 1L;
        Mockito.doNothing().when(tarefaService).iniciarExecucaoTarefa(tarefaId);

        ResponseEntity<?> response = tarefaController.iniciarExecucaoTarefa(tarefaId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Tarefa iniciada com sucesso!", response.getBody());
    }

    @Test
    void iniciarExecucaoTarefa_BadRequestException() {
        
        Long tarefaId = 1L;
        String msgErroInterna = "Erro ao iniciar tarefa";
        Mockito.doThrow(new BadRequestException(msgErroInterna)).when(tarefaService).iniciarExecucaoTarefa(tarefaId);

        ResponseEntity<?> response = tarefaController.iniciarExecucaoTarefa(tarefaId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Não foi possível iniciar a tarefa:\n" + msgErroInterna, response.getBody());
    }

    @Test
    void iniciarExecucaoTarefa_InternalServerError() {
        
        Long tarefaId = 1L;
        Mockito.doThrow(new RuntimeException("Erro interno")).when(tarefaService).iniciarExecucaoTarefa(tarefaId);

        ResponseEntity<?> response = tarefaController.iniciarExecucaoTarefa(tarefaId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Não foi possível iniciar a tarefa. Tente novamente mais tarde.", response.getBody());
    }
}
