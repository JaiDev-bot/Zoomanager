package com.example.Zoomanager.controllers;

import com.example.Zoomanager.dto.tarefaDTO.TarefaSaveDTO;
import com.example.Zoomanager.exceptions.BadRequestException;
import com.example.Zoomanager.service.interfaceService.TarefaService;
import com.example.Zoomanager.swagger.TarefaSwagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa")
public class TarefaController implements TarefaSwagger {

    private static Logger logger = LoggerFactory.getLogger(TarefaController.class.getName());

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<?> addTarefa(@RequestBody TarefaSaveDTO alertaSaveDTO) {

        try{
            tarefaService.addTarefa(alertaSaveDTO);
            return ResponseEntity.created(null).body("Tarefa criada com sucesso!");
        }
        catch(BadRequestException e){
            String msgErro = "Não foi possível criar a tarefa:\n" + e.getMessage();
            logger.error(msgErro, e);
            return ResponseEntity.badRequest().body(msgErro);
        }
        catch (Exception e) {
            String msgErro = "Não foi possível criar a tarefa.";
            logger.error(msgErro, e);
            return ResponseEntity.internalServerError().body(msgErro);
        }
    }
}