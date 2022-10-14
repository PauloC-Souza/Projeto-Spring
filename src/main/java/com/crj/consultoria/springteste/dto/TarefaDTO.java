package com.crj.consultoria.springteste.dto;

import java.time.LocalDate;

import com.crj.consultoria.springteste.entity.Tarefa;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate prazo;
	private Integer departamento;
	private Double duracao;
	private boolean finalizado;
	private Long idPessoaAlocada;
	
	public TarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.prazo = tarefa.getPrazo();
		this.departamento = tarefa.getIdDepartamento();
		this.duracao = tarefa.getDuracao();
		this.finalizado = tarefa.isFinalizado();
	}
}


