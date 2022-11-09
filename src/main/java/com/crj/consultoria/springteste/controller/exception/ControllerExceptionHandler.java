package com.crj.consultoria.springteste.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crj.consultoria.springteste.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(ObjectNotFoundException.class)
	    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException i, HttpServletRequest request) {

	        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), i.getMessage(), System.currentTimeMillis());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handleException(MethodArgumentNotValidException exception) {

		ErrorDTO dto = new ErrorDTO(HttpStatus.BAD_REQUEST, "Validation error");

		dto.setDetailedMessages(exception.getBindingResult().getAllErrors().stream()
				.map(erro -> erro.unwrap(ConstraintViolation.class))
				.map(erro -> String.format("'%s' %s", erro.getPropertyPath(), erro.getMessage()))
				.collect(Collectors.toList()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}

	@Data
	public static class ErrorDTO {

		private final int status;
		private final String error;
		private final String message;
		private List<String> detailedMessages;

		public ErrorDTO(HttpStatus httpStatus, String message) {
			status = httpStatus.value();
			error = httpStatus.getReasonPhrase();
			this.message = message;
		}
	}
	 
}
