package com.crj.consultoria.springteste.dto;

import java.util.List;

import com.crj.consultoria.springteste.entity.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Integer departamento;
	private String descricao;
	private Integer todaHorasTarefas;
	private List<PessoaMediaDTO> media;
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.departamento = pessoa.getIdDepartamento();
	}
	
	
	
}
