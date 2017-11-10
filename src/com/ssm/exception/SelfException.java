package com.ssm.exception;

public class SelfException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SelfException(){
		
	}
	
	public SelfException(String msg){
		super(msg);
	}
}
