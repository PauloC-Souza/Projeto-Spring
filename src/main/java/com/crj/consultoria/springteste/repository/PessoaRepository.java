package com.crj.consultoria.springteste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crj.consultoria.springteste.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query("SELECT p FROM Pessoa p WHERE p.departamento = :id ORDER BY p.id asc")
	 List<Pessoa> findPessoaByDepartamento(@Param("id") Integer id);
}
