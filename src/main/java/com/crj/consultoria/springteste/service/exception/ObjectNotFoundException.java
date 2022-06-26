package com.crj.consultoria.springteste.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String error) {
        super(error);
    }

    public ObjectNotFoundException(String error, Throwable cause) {
        super(error, cause);
    }
}
