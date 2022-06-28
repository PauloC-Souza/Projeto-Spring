package com.crj.consultoria.springteste.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crj.consultoria.springteste.dto.DepartamentoDTO;
import com.crj.consultoria.springteste.enuns.DepartamentoEnum;
import com.crj.consultoria.springteste.repository.PessoaRepository;
import com.crj.consultoria.springteste.repository.TarefaRepository;
import com.crj.consultoria.springteste.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public List<DepartamentoDTO> buscarDepartamentos(){
        List<DepartamentoDTO> listaDepartamentos = new ArrayList<>();

        DepartamentoDTO financeiro = new DepartamentoDTO();
        DepartamentoDTO comercial = new DepartamentoDTO();
        DepartamentoDTO desenvolvimento = new DepartamentoDTO();

        financeiro.setQuantidadePessoas(pessoaRepository.buscarTotalPessoasPorDepartamento(DepartamentoEnum.FINANCEIRO.getCod()));
        financeiro.setQuantidadeTarefas(tarefaRepository.buscarTotalTarefasPorDepartamento(DepartamentoEnum.FINANCEIRO.getCod()));
        financeiro.setDepartamento(DepartamentoEnum.FINANCEIRO.getDescricao());
        comercial.setQuantidadePessoas(pessoaRepository.buscarTotalPessoasPorDepartamento(DepartamentoEnum.COMERCIAL.getCod()));
        comercial.setQuantidadeTarefas(tarefaRepository.buscarTotalTarefasPorDepartamento(DepartamentoEnum.COMERCIAL.getCod()));
        comercial.setDepartamento(DepartamentoEnum.COMERCIAL.getDescricao());
        desenvolvimento.setQuantidadePessoas(pessoaRepository.buscarTotalPessoasPorDepartamento(DepartamentoEnum.DESENVOLVIMENTO.getCod()));
        desenvolvimento.setQuantidadeTarefas(tarefaRepository.buscarTotalTarefasPorDepartamento(DepartamentoEnum.DESENVOLVIMENTO.getCod()));
        desenvolvimento.setDepartamento(DepartamentoEnum.DESENVOLVIMENTO.getDescricao());

        listaDepartamentos.addAll(Arrays.asList(financeiro,comercial, desenvolvimento));
        return listaDepartamentos;
    }
}
