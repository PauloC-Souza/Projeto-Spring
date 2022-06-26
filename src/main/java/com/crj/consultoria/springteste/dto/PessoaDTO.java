package com.crj.consultoria.springteste.dto;

import java.util.List;

import com.crj.consultoria.springteste.enuns.DepartamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private DepartamentoEnum departamento;
	
}
