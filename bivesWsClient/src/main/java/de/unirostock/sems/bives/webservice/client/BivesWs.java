package de.unirostock.sems.bives.webservice.client;

import de.unirostock.sems.bives.webservice.client.exception.BivesClientException;
import de.unirostock.sems.bives.webservice.client.exception.BivesException;


/**
 * The Interface to send a request to the BiVeS web service.
 */
public interface BivesWs {
	
	/**
	 * Perform a single-file-request.
	 *
	 * @param request the BiVeS request
	 * @return the response from the web service
	 * @throws BivesClientException the bives client exception
	 * @throws BivesException the bives exception
	 */
	public BivesSingleFileResponse performRequest( BivesSingleFileRequest request ) throws BivesClientException, BivesException;
	
	/**
	 * Perform comparison request.
	 *
	 * @param request the BiVeS request
	 * @return the comparison response from the web service
	 * @throws BivesClientException the bives client exception
	 * @throws BivesException the bives exception
	 */
	public BivesComparisonResponse performRequest( BivesComparisonRequest request ) throws BivesClientException, BivesException;
	
}
