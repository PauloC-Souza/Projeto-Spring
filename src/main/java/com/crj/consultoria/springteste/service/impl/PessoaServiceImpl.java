package com.crj.consultoria.springteste.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.dto.PessoaMediaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.entity.Tarefa;
import com.crj.consultoria.springteste.repository.PessoaRepository;
import com.crj.consultoria.springteste.repository.TarefaRepository;
import com.crj.consultoria.springteste.service.PessoaService;
import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;
import com.crj.consultoria.springteste.shared.Mensagens;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Override
	public String cadastrarPessoa(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		repository.save(montarEntity(dto, pessoa));
		return Mensagens.CADASTRO_SUCESSO;
	}
	
	@Override
	public String editarPessoa(Long id, PessoaDTO dto) {
		Pessoa pessoa = getEntity(id);
		repository.save(montarEntity(dto, pessoa));
		return Mensagens.ATUALIZAR_SUCESSO;
	}
	
	@Override
	public String removerPessoa(Long id) {
		repository.delete(getEntity(id));
		return Mensagens.DELETAR_SUCESSO;
	}
	
	@Override
	public List<PessoaDTO> buscarPessoaPorNomeEPeriodo() {
		List<Pessoa> pessoas = repository.findAll();
		List<PessoaDTO> dto = new ArrayList<>();
		pessoas.stream().forEach((p) -> {
			PessoaDTO pessoa = new PessoaDTO(p);
			List<Tarefa> tarefasPessoa = tarefaRepository.buscarMediaHorasGastasPorTarefas(p.getId());
			PessoaMediaDTO media = new PessoaMediaDTO();
			List<PessoaMediaDTO> listaMedia = new ArrayList<>();
			tarefasPessoa.stream().forEach((tp) -> {
				media.setMediaHorasGastas(tp.getDuracao());
				media.setPeriodo(tp.getPrazo().getYear());
				listaMedia.add(media);
			});
			pessoa.setMedia(listaMedia);
			dto.add(pessoa);
		});
		return dto;
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
	
	public List<Pessoa> findPessoaByDepartamento(Integer id) {
		return repository.findPessoaByDepartamento(id);
	}

}
