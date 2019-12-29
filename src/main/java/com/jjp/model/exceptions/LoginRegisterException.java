package com.jjp.model.exceptions;

public class LoginRegisterException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginRegisterException() {
		super();
	}

	public LoginRegisterException(String message) {
		super(message);
	}

	public LoginRegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginRegisterException(Throwable cause) {
		super(cause);
	}
}
