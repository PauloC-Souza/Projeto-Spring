package com.crj.consultoria.springteste.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(ObjectNotFoundException.class)
	    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException i, HttpServletRequest request) {

	        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), i.getMessage(), System.currentTimeMillis());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }
	 
}
