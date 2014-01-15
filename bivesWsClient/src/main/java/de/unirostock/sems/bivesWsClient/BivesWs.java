package de.unirostock.sems.bivesWsClient;

import java.util.Map;

public interface BivesWs {
	
	public BivesRequest startRequest(Map<String, String> models);
	
	public BivesResult performRequest( BivesRequest request );
	
}
