package com.globlotech.wfm.user.vo;

import java.io.Serializable;

/**
 * @author Manikandan
 *
 */
@SuppressWarnings("serial")
public class MessageVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2519163015629896491L;

	private String operation ;
	
	private String status ;
	
	private String message;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
