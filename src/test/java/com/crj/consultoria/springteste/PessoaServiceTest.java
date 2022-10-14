package com.crj.consultoria.springteste;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.service.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {

    @Autowired
    private PessoaService service;


    @Test
    public void CadastrarPessoaTest() {
        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setDepartamento(1);
        String retorno = service.cadastrarPessoa(dto);
        assertFalse(retorno.isEmpty());
        assertEquals(retorno, "Registro cadastrado com sucesso! ;)");
    }

    @Test
    public void buscarPessoaTest() {
        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setDepartamento(1);
        service.cadastrarPessoa(dto);
        Pessoa pessoa = service.getEntity(1L);
        assertNotNull(pessoa);
        assertNotNull(pessoa.getId());
        assertNotNull(pessoa.getNome());
        assertNotNull(pessoa.getIdDepartamento());
        assertEquals(pessoa.getNome(), "Teste");
    }
}
