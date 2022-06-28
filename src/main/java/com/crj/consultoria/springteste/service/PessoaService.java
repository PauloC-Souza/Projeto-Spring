package com.crj.consultoria.springteste.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;

@Component
public interface PessoaService {
	
	String cadastrarPessoa(PessoaDTO dto);
	
	String editarPessoa(Long id, PessoaDTO dto);
	
	String removerPessoa(Long id);
	
	Pessoa getEntity(Long id);
	
	List<Pessoa> findPessoaByDepartamento(Integer id);
	
	List<PessoaDTO> buscarPessoaPorNomeEPeriodo();
	
    List<PessoaDTO> buscarPessoas();

}
