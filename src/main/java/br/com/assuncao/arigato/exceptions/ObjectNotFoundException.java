package br.com.assuncao.arigato.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3803637625756299597L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
