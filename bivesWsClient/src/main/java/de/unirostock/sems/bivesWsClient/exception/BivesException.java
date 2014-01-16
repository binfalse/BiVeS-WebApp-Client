package de.unirostock.sems.bivesWsClient.exception;

public class BivesException extends Exception {

	private static final long serialVersionUID = -1164949116175387252L;

	public BivesException() {
	}

	public BivesException(String message) {
		super(message);
	}

	public BivesException(Throwable cause) {
		super(cause);
	}

	public BivesException(String message, Throwable cause) {
		super(message, cause);
	}

	public BivesException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
