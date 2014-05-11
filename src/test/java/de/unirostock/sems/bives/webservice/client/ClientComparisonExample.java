/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;

import de.unirostock.sems.bives.webservice.client.exception.BivesClientException;
import de.unirostock.sems.bives.webservice.client.exception.BivesException;
import de.unirostock.sems.bives.webservice.client.impl.HttpBivesClient;


/**
 * please also see usage in web: https://sems.uni-rostock.de/trac/bivesws-client/
 * 
 * @author Martin Scharm
 *
 */
public class ClientComparisonExample
{
	
	/**
	 * @param args
	 * @throws BivesException 
	 * @throws BivesClientException 
	 */
	public static void main (String[] args) throws BivesClientException, BivesException
	{
		BivesComparisonRequest request = new BivesComparisonRequest (
			"http://budhat.sems.uni-rostock.de/download?downloadModel=24",
			"http://budhat.sems.uni-rostock.de/download?downloadModel=25");
		
		// add commands
		request.addCommand(BivesComparisonRequest.COMMAND_FORCE_SBML);
		request.addCommand(BivesComparisonRequest.COMMAND_REACTIONS_GRAPHML);
		request.addCommand(BivesComparisonRequest.COMMAND_REPORT_HTML);
				
		// send request and get response
		BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
		BivesComparisonResponse result = bives.performRequest(request);
		
		// anything bad happened?
		if (result.hasError ())
		{
			for (String err : result.getErrors ())
				System.err.println ("ERROR: " + err);
			System.exit (1);
		}
		
		
		System.out.println ("the highlighted reaction network encoded in graphml:");
		System.out.println (result.getResult (BivesComparisonResponse.COMMAND_REACTIONS_GRAPHML));
		

		System.out.println ("the report encoded in html:");
		System.out.println (result.getResult (BivesComparisonResponse.COMMAND_REPORT_HTML));
		
		
	}
	
}
