package com.crj.consultoria.springteste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crj.consultoria.springteste.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	@Query("SELECT t FROM Tarefa t WHERE t.pessoaAlocada = NULL ORDER BY t.prazo desc")
	 List<Tarefa> listarTarefas();
	
	@Query("SELECT new Tarefa(t.prazo, AVG(t.duracao)) FROM Tarefa t WHERE t.pessoaAlocada.id = :id GROUP BY t.prazo")
	 List<Tarefa> buscarMediaHorasGastasPorTarefas(@Param("id") Long id);
}
