package com.crj.consultoria.springteste.enuns;

import java.util.Arrays;
import java.util.Objects;

import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;

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
    
    public static DepartamentoEnum toEnum(Integer cod) {
		if (Objects.isNull(cod)) {
			return null;
		}
		for (DepartamentoEnum item : DepartamentoEnum.values()) {
			if (item.cod == cod) {
				return item;
			}
		}
		throw new ObjectNotFoundException("Código do departamento inválido: " + cod);
	}
	
	public static String getDescricaoDepartamentoEnum(DepartamentoEnum departamentoEnum) {
        return Arrays.stream(DepartamentoEnum.values())
                .filter(item -> item == departamentoEnum)
                .map(DepartamentoEnum::getDescricao)
                .findFirst().orElse(null);
    }

}
