package com.crj.consultoria.springteste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crj.consultoria.springteste.dto.TarefaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.entity.Tarefa;
import com.crj.consultoria.springteste.repository.PessoaRepository;
import com.crj.consultoria.springteste.repository.TarefaRepository;
import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;
import com.crj.consultoria.springteste.shared.Mensagens;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository repository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	
	public String cadastrarTarefa(TarefaDTO dto) {
		return Mensagens.CADASTRO_SUCESSO;
	}
	
	private Tarefa montarTarefa(TarefaDTO dto, Tarefa entity) {
		entity.setDepartamento(dto.getDepartamento());
		entity.setDescricao(dto.getDescricao());
		entity.setDuracao(dto.getDuracao());
		entity.setFinalizado(dto.isFinalizado());
		entity.setPrazo(dto.getPrazo());
//		entity.setPessoaAlocada(pessoaService.getEntity(dto.getIdPessoaAlocada()));
		return entity;
		
	}
	
	public Tarefa getEntity(Long id) {
        Optional<Tarefa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        		Mensagens.REGISTRO_NAO_ENCONTRADO + id));
    }
	
}
