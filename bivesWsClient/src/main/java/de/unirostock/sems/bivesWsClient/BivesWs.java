package de.unirostock.sems.bivesWsClient;


public interface BivesWs {
	
//	public BivesRequest startRequest(Map<String, String> models);
	
	public BivesResult performRequest( BivesRequest request );
	
}
