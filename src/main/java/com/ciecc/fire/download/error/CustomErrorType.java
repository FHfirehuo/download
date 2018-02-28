package com.ciecc.fire.download.error;

public class CustomErrorType {
	
	private int value;
	private String message;

	public CustomErrorType(int value, String message) {
		this.value = value;
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
