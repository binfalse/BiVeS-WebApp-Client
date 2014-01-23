package de.unirostock.sems.bivesWsClient;

import de.unirostock.sems.bivesWsClient.exception.BivesClientException;
import de.unirostock.sems.bivesWsClient.exception.BivesException;


public interface BivesWs {
	
	public BivesSingleFileResponse performRequest( BivesSingleFileRequest request ) throws BivesClientException, BivesException;
	public BivesComparisonResponse performRequest( BivesComparisonRequest request ) throws BivesClientException, BivesException;
	
}
