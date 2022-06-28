package com.crj.consultoria.springteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crj.consultoria.springteste.dto.DepartamentoDTO;
import com.crj.consultoria.springteste.service.DepartamentoService;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DepartamentoDTO>> buscarDepartamentos(){
        return ResponseEntity.ok(departamentoService.buscarDepartamentos());
    }

}