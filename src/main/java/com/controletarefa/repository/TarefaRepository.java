package com.controletarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controletarefa.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

}
