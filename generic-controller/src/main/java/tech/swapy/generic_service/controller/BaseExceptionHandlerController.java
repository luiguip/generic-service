package tech.swapy.generic_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import tech.swapy.generic_service.exceptions.IdNotFoundException;

public abstract class BaseExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Inexistent resource.")
	@ExceptionHandler(IdNotFoundException.class)
	public void idNotFound() {
	}
}
