package com.crj.consultoria.springteste;

import com.crj.consultoria.springteste.controller.PessoaController;
import com.crj.consultoria.springteste.dto.PessoaDTO;
import com.crj.consultoria.springteste.service.repository.PessoaRepository;
import com.crj.consultoria.springteste.service.repository.TarefaRepository;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService service;

    @MockBean
    private PessoaRepository repository;

    @MockBean
    TarefaRepository tarefaRepository;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    private final PessoaDTO PESSOA_1 = new PessoaDTO("Teste", 1);

    private static String asJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void deveRetornarSucesso_quandoCadastrarPessoa() throws Exception {
        Mockito
                .when(this.service.cadastrarPessoa(Mockito.any(PessoaDTO.class)))
                .thenReturn(Mensagens.CADASTRO_SUCESSO);
        mockMvc
                .perform(MockMvcRequestBuilders
                .post(("/pessoas"))
                .content(asJsonString(PESSOA_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.is(Mensagens.CADASTRO_SUCESSO)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deveRetornarErro_quandoCadastrarPessoa() throws Exception {
        PESSOA_1.setNome(null);
        Mockito
                .when(this.service.cadastrarPessoa(Mockito.any(PessoaDTO.class)))
                .thenReturn(null);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(("/pessoas"))
                        .content(asJsonString(PESSOA_1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Validation error")))
                .andExpect(jsonPath("$.detailedMessages[0]", is("'nome' O nome não pode ser nulo")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deveRetornarLista_quandoBuscarPessoas() throws Exception {
        Mockito
                .when(this.service.buscarPessoas())
                .thenReturn(List.of(PESSOA_1));
        Mockito
                .when(this.tarefaRepository.buscarTotalHorasTarefasPorPessoa(Mockito.any(Long.class)))
                .thenReturn(2);
        PESSOA_1.setTodaHorasTarefas(2);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(("/pessoas"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.is("Teste")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departamento", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].todaHorasTarefas", Matchers.is(2)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deveRetornarVazio_quandoBuscarPessoas() throws Exception {
        Mockito
                .when(this.service.buscarPessoas())
                .thenReturn(new ArrayList<>());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(("/pessoas"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
