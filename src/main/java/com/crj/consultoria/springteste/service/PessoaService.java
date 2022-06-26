package com.crj.consultoria.springteste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.repository.PessoaRepository;
import com.crj.consultoria.springteste.repository.TarefaRepository;
import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;
import com.crj.consultoria.springteste.shared.Mensagens;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	public String cadastrarPessoa(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		repository.save(montarEntity(dto, pessoa));
		return Mensagens.CADASTRO_SUCESSO;
	}
	
	public String editarPessoa(Long id, PessoaDTO dto) {
		Pessoa pessoa = getEntity(id);
		repository.save(montarEntity(dto, pessoa));
		return Mensagens.ATUALIZAR_SUCESSO;
	}
	
	public String removerPessoa(Long id) {
		repository.delete(getEntity(id));
		return Mensagens.DELETAR_SUCESSO;
	}
	
	private Pessoa montarEntity(PessoaDTO dto, Pessoa entity) {
		entity.setNome(dto.getNome());
		entity.setDepartamento(dto.getDepartamento());
		return entity;
	}
	
	public Pessoa getEntity(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        		Mensagens.REGISTRO_NAO_ENCONTRADO + " id: " + id));
    }

}
