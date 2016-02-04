package com.spring.controllers;

public enum UnexpectedError {

	dbInsertErr("error.unexpected.db.insert"),
	dbUpdateErr("error.unexpected.db.update");
	
	private String errorCode; //Error code are mapped to message.property

	private UnexpectedError(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
