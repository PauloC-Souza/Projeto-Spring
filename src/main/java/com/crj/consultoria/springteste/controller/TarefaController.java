package com.crj.consultoria.springteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crj.consultoria.springteste.dto.TarefaDTO;
import com.crj.consultoria.springteste.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

	@Autowired
	TarefaService service;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> cadastrarTarefa(@RequestBody TarefaDTO dto) {
        return ResponseEntity.ok().body(service.cadastrarTarefa(dto));
    }
	
	@RequestMapping(value = "/finalizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> finalizarTarefa(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.finalizarTarefa(id));
    }
	
	@RequestMapping(value = "/alocar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> alocarPessoaTarefa(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.alocarPessoaTarefa(id));
    }
	
	@RequestMapping(value = "/pendentes", method = RequestMethod.GET)
    public ResponseEntity<List<TarefaDTO>> listarTarefas(){
        return ResponseEntity.ok(service.listarTarefas());
    }
	
}
