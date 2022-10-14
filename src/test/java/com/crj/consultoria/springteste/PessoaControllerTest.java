package com.crj.consultoria.springteste;

import com.crj.consultoria.springteste.controller.PessoaController;
import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.entity.Pessoa;
import com.crj.consultoria.springteste.repository.PessoaRepository;
import com.crj.consultoria.springteste.service.PessoaService;
import com.crj.consultoria.springteste.shared.Mensagens;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService service;

    @MockBean
    private PessoaRepository repository;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    private static String asJsonString(Object object) {

        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void deveRetornarSucesso_quandoCadastrarPessoa() throws Exception {
        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setDepartamento(1);
        Mockito.when(this.service.cadastrarPessoa(Mockito.any(PessoaDTO.class)))
                .thenReturn(Mensagens.CADASTRO_SUCESSO);
        mockMvc.perform(MockMvcRequestBuilders
                .post(("/pessoas"))
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.is(Mensagens.CADASTRO_SUCESSO)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
