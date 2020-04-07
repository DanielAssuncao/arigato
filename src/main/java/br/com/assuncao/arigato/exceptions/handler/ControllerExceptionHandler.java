package br.com.assuncao.arigato.exceptions.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.assuncao.arigato.exceptions.GeneralException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<StandardError> objectNotFound(GeneralException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
