package com.crj.consultoria.springteste.controller.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    public static final long serialVersionUID = 1L;
    private Integer status;
    private String mensagem;
    private Long timeStamp;
} 
