package com.crj.consultoria.springteste.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import com.crj.consultoria.springteste.entity.Tarefa;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaMediaDTO extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double mediaHorasGastas;
	private int periodo;
    
}
