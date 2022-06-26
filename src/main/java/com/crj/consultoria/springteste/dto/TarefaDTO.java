package com.crj.consultoria.springteste.dto;

import java.time.LocalDate;

import com.crj.consultoria.springteste.enuns.DepartamentoEnum;

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
	private LocalDate prazo;
	private DepartamentoEnum departamento;
	private Integer duracao;
	private boolean finalizado;
	private Long IdPessoaAlocada;
}
