package br.com.assuncao.arigato.exceptions;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 3803637625756299597L;

	public GeneralException(String msg) {
		super(msg);
	}
	
	public GeneralException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
