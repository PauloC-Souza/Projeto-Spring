package com.crj.consultoria.springteste.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crj.consultoria.springteste.dto.TarefaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.entity.Tarefa;
import com.crj.consultoria.springteste.service.repository.TarefaRepository;
import com.crj.consultoria.springteste.service.PessoaService;
import com.crj.consultoria.springteste.service.TarefaService;
import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;
import com.crj.consultoria.springteste.shared.Mensagens;

@Service
public class TarefaServiceImpl implements TarefaService{
	
	@Autowired
	TarefaRepository repository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Override
	public String cadastrarTarefa(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		repository.save(montarTarefa(dto, tarefa));
		return Mensagens.CADASTRO_SUCESSO;
	}
	
	@Override
	public String finalizarTarefa(Long id) {
		Tarefa tarefa = getEntity(id);
		tarefa.setFinalizado(true);
		repository.save(tarefa);
		return "Tarefa Finalizada com sucesso!";
	}
	
	@Override
	public String alocarPessoaTarefa(Long id) {
		Tarefa tarefa = getEntity(id);
		List<Pessoa> pessoa = pessoaService.findPessoaByDepartamento(tarefa.getIdDepartamento());
		if(!pessoa.isEmpty()) {
		tarefa.setPessoaAlocada(pessoa.get(0));
		repository.save(tarefa);
		} else {
			throw new ObjectNotFoundException("Nenhuma pessoa encontrada do departamento desta tarefa!");
		}
		return "Pessoa alocada com sucesso!";
	}
	
	@Override
	public List<TarefaDTO> listarTarefas(){
		List<Tarefa> tarefas = repository.listarTarefas();
		List<TarefaDTO> retorno = new ArrayList<>();
		int index = 0;
		for(Tarefa item : tarefas) {
			TarefaDTO tarefa = new TarefaDTO(item);
			retorno.add(tarefa);
			if(index == 2) {
				return retorno;
			}
			index++;
		}
		return retorno;
	}
	
	private Tarefa montarTarefa(TarefaDTO dto, Tarefa entity) {
		entity.setIdDepartamento(dto.getDepartamento());
		entity.setDescricao(dto.getDescricao());
		entity.setDuracao(dto.getDuracao());
		entity.setFinalizado(dto.isFinalizado());
		entity.setPrazo(dto.getPrazo());
		entity.setTitulo(dto.getTitulo());
		if(Objects.nonNull(dto.getIdPessoaAlocada())) {
			entity.setPessoaAlocada(pessoaService.getEntity(dto.getIdPessoaAlocada()));
		}
		return entity;
		
	}
	
	public Tarefa getEntity(Long id) {
        Optional<Tarefa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        		Mensagens.REGISTRO_NAO_ENCONTRADO + " id: " + id));
    }
	
}
