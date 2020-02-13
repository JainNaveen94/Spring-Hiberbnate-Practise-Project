package com.navtech.custome.exception;

@SuppressWarnings("serial")
public class DataBaseDoNotInsertException extends RuntimeException{

	public DataBaseDoNotInsertException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataBaseDoNotInsertException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataBaseDoNotInsertException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
