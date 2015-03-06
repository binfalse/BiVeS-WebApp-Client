package de.unirostock.sems.bives.webservice.client.exception;

/**
 * The Class BivesException.
 */
public class BivesException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1164949116175387252L;

	/**
	 * Instantiates a new bives exception.
	 */
	public BivesException() {
	}

	/**
	 * Instantiates a new bives exception.
	 *
	 * @param message the message
	 */
	public BivesException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new bives exception.
	 *
	 * @param cause the cause
	 */
	public BivesException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new bives exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BivesException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new bives exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public BivesException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
