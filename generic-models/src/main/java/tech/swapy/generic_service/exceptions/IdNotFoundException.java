package tech.swapy.generic_service.exceptions;

public class IdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 667886627930305081L;

	public IdNotFoundException(String message) {
		super(message);
	}
	
}
