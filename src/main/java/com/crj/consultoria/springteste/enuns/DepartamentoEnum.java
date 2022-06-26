package com.crj.consultoria.springteste.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DepartamentoEnum {

    FINANCEIRO(1, "Financeiro"),
    COMERCIAL(2, "Comercial"),
    DESENVOLVIMENTO(3, "Desenvolvimento");

    private int cod;
    private String descricao;

}
