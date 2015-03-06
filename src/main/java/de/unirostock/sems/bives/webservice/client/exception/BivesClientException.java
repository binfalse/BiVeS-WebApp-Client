package de.unirostock.sems.bives.webservice.client.exception;

/**
 * The Class BivesClientException.
 */
public class BivesClientException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6348556689756878361L;

	/**
	 * Instantiates a new bives client exception.
	 */
	public BivesClientException() {
	}

	/**
	 * Instantiates a new bives client exception.
	 *
	 * @param message the message
	 */
	public BivesClientException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new bives client exception.
	 *
	 * @param cause the cause
	 */
	public BivesClientException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new bives client exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BivesClientException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new bives client exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public BivesClientException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
