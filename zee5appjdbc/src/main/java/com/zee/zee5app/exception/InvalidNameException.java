package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidNameException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
