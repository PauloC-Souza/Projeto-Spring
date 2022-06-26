package com.crj.consultoria.springteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crj.consultoria.springteste.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
