package de.unirostock.sems.bivesWsClient.exception;

public class BivesClientException extends Exception {

	private static final long serialVersionUID = 6348556689756878361L;

	public BivesClientException() {
	}

	public BivesClientException(String message) {
		super(message);
	}

	public BivesClientException(Throwable cause) {
		super(cause);
	}

	public BivesClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public BivesClientException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
