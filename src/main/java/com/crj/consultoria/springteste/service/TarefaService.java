package com.crj.consultoria.springteste.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crj.consultoria.springteste.dto.TarefaDTO;

@Component
public interface TarefaService {
	
	String cadastrarTarefa(TarefaDTO dto);
	
	String finalizarTarefa(Long id);
	
	String alocarPessoaTarefa(Long id);
	
	List<TarefaDTO> listarTarefas();

}
