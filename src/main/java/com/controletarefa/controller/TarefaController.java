package com.controletarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controletarefa.entities.Tarefa;
import com.controletarefa.service.TarefaService;

@RestController
@RequestMapping("/Tarefa")
public class TarefaController {
    private final TarefaService TarefaService;

    @Autowired
    public TarefaController(TarefaService TarefaService) {
        this.TarefaService = TarefaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable long id) {
        Tarefa Tarefa = TarefaService.getTarefaById(id);
        if (Tarefa != null) {
            return ResponseEntity.ok(Tarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> buscaTodasTarefasControl() {
        List<Tarefa> Tarefas = TarefaService.getAllTarefas();
        return ResponseEntity.ok(Tarefas);
    }

    @PostMapping
    public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa Tarefa) {
        Tarefa salvaTarefa = TarefaService.saveTarefa(Tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody Tarefa Tarefa) {
        Tarefa alteraTarefa = TarefaService.changeTarefa(id, Tarefa);
        if (alteraTarefa != null) {
            return ResponseEntity.ok(Tarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaTarefaControl(@PathVariable Long id) {
        boolean apagar = TarefaService.deleteTarefa(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

