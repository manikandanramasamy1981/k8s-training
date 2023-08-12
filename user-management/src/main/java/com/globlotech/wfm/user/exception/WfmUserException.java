package com.globlotech.wfm.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WfmUserException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6714550251019913176L;

	public WfmUserException(String message) {
        super(message);
    }

    public WfmUserException(String message, Throwable cause) {
        super(message, cause);
    }
}