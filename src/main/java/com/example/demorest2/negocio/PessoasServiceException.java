package com.example.demorest2.negocio;

public class PessoasServiceException extends RuntimeException{

	public PessoasServiceException() {
		super();
	}

	public PessoasServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoasServiceException(String message) {
		super(message);
	}

	public PessoasServiceException(Throwable cause) {
		super(cause);
	}

}
