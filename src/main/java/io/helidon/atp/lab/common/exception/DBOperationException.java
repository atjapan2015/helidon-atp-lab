package io.helidon.atp.lab.common.exception;

public class DBOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522546117331314866L;

	public DBOperationException() {
		super();
	}

	public DBOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DBOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBOperationException(String message) {
		super(message);
	}

	public DBOperationException(Throwable cause) {
		super(cause);
	}

}