package br.com.isl.alertasamu.services.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ServiceExceptionHandler {
 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
         
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	
}
	//Caso haja uma tentativa de exclusão de um alerta com status associados.
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> IntegridadeDados(DataIntegrityException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
         
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	
}
}
