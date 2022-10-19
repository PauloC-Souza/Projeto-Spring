package com.crj.consultoria.springteste;

import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.service.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {

    @Autowired
    private PessoaService service;


    private final PessoaDTO PESSOA_1 = new PessoaDTO("Teste", 1);
    private final PessoaDTO PESSOA_2 = new PessoaDTO("Teste2", 1);

    @Test
    public void CadastrarPessoaTest() {
        String retorno = service.cadastrarPessoa(PESSOA_1);
        assertFalse(retorno.isEmpty());
        assertEquals(retorno, "Registro cadastrado com sucesso! ;)");
    }

    @Test
    public void buscarPessoaTest() {
        service.cadastrarPessoa(PESSOA_1);
        Pessoa pessoa = service.getEntity(1L);
        assertNotNull(pessoa);
        assertNotNull(pessoa.getId());
        assertNotNull(pessoa.getNome());
        assertNotNull(pessoa.getIdDepartamento());
        assertEquals(pessoa.getNome(), "Teste");
    }

    @Test
    public void buscarListaPessoasTest(){
        service.cadastrarPessoa(PESSOA_1);
        service.cadastrarPessoa(PESSOA_2);
        List<PessoaDTO> listaPessoas = service.buscarPessoas();
        assertFalse(listaPessoas.isEmpty());
        assertEquals(listaPessoas.get(0).getNome(), "Teste");
        assertEquals(listaPessoas.get(1).getNome(), "Teste2");
        assertNotNull(listaPessoas.stream().map(PessoaDTO::getNome));
        assertNotNull(listaPessoas.stream().map(PessoaDTO::getDepartamento));
    }
}
