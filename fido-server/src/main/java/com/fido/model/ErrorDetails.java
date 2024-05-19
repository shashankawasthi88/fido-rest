package com.fido.model;

import com.fido.constants.ErrorCode;

public class ErrorDetails {
	
	/**
	 * Error code
	 */
	ErrorCode errorCode;
	
	/**
	 * Error Message
	 */
	String errorMessage;
	
	public ErrorDetails(ErrorCode errorCode, String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
