package de.unirostock.sems.bivesWsClient;

import de.unirostock.sems.bivesWsClient.exception.BivesClientException;
import de.unirostock.sems.bivesWsClient.exception.BivesException;


public interface BivesWs {
	
//	public BivesRequest startRequest(Map<String, String> models);
	
	public BivesResult performRequest( BivesRequest request ) throws BivesClientException, BivesException;
	
}
