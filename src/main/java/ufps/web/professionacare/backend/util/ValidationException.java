package ufps.web.professionacare.backend.util;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String msg;
	private HttpStatus status;
	private Exception exception;

	public ValidationException(String msg, Exception exception, HttpStatus status) {
		this.msg = msg;
		this.status = status;
		this.exception = exception;
	}

	public String getMsg() {
		return msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Exception getException() {
		return exception;
	}

}
