package com.crj.consultoria.springteste.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crj.consultoria.springteste.dto.DepartamentoDTO;


@Component
public interface DepartamentoService {

    List<DepartamentoDTO> buscarDepartamentos();

}