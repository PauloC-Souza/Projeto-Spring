package com.crj.consultoria.springteste.dto;

import com.crj.consultoria.springteste.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

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
	@NotNull(message = "O nome não pode ser nulo")
	private String nome;
	@NotNull(message = "O departamento não pode ser nulo")
	private Integer departamento;
	private String descricao;
	private Integer todaHorasTarefas;
	private List<PessoaMediaDTO> media;
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.departamento = pessoa.getIdDepartamento();
	}

	public PessoaDTO(String nome, Integer departamento) {
		this.nome = nome;
		this.departamento = departamento;
	}
}
