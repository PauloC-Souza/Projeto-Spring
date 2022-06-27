package com.crj.consultoria.springteste.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.service.PessoaService;
import com.crj.consultoria.springteste.service.impl.PessoaServiceImpl;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> cadastrarPessoa(@RequestBody PessoaDTO dto) {
        return ResponseEntity.ok().body(service.cadastrarPessoa(dto));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editarPessoa(@PathVariable("id") Long id, @RequestBody PessoaDTO dto) {
        return ResponseEntity.ok().body(service.editarPessoa(id, dto));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removerPessoa(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.removerPessoa(id));
    }
    
    @RequestMapping(value = "/gastos", method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> buscarPessoaPorNomeEPeriodo() {
        return ResponseEntity.ok(service.buscarPessoaPorNomeEPeriodo());
    }

}
