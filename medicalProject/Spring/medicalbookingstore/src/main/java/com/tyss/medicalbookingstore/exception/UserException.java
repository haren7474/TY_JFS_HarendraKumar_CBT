package com.tyss.medicalbookingstore.exception;

public class UserException extends RuntimeException {
	
	private String msg;

	public UserException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
