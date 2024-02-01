package com.controletarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controletarefa.entities.Tarefa;
import com.controletarefa.repository.TarefaRepository;

@Service
public class TarefaService {
	private final TarefaRepository TarefaRepository;
	

	@Autowired
	public TarefaService(TarefaRepository TarefaRepository) {
		this.TarefaRepository = TarefaRepository;
	}

	public List<Tarefa> getAllTarefas() {
		return TarefaRepository.findAll();
	}

	public Tarefa getTarefaById(Long id) {
		Optional<Tarefa> Tarefa = TarefaRepository.findById(id);
		return Tarefa.orElse(null);
	}

	public Tarefa saveTarefa(Tarefa Tarefa) {
		return TarefaRepository.save(Tarefa);
	}

	public Tarefa changeTarefa(Long id, Tarefa changeU) {
		Optional<Tarefa> existeTarefa = TarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			changeU.setId(id);
			return TarefaRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteTarefa(Long id) {
		Optional<Tarefa> existeTarefa= TarefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			TarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
