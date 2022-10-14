package com.crj.consultoria.springteste.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "tarefa")
public class Tarefa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "prazo")
	private LocalDate prazo;
	private Integer idDepartamento;
	@Column(name = "duracao")
	private Double duracao;
	@Column(name = "finalizado")
	private boolean finalizado;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
	private Pessoa pessoaAlocada;

	public Tarefa(LocalDate prazo, Double duracao) {
		this.prazo = prazo;
		this.duracao = duracao;
	}
	
	

}
