/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;

import java.util.Map;

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
		BivesSingleFileRequest request = new BivesSingleFileRequest("http://budhat.sems.uni-rostock.de/download?downloadModel=25");
		//BivesSingleFileRequest request = new BivesSingleFileRequest("http://budhat.sems.uni-rostock.de/download?downloadModel=27");
		//BivesSingleFileRequest request = new BivesSingleFileRequest("http://models.cellml.org/exposure/385475ef63ff3f2d42e3dcb52f3982d2/MainDVad.cellml");
		
		// add commands
		request.addCommand(BivesSingleFileRequest.COMMAND_DOCUMENT_TYPE);
		request.addCommand(BivesSingleFileRequest.COMMAND_META);
		//request.addCommand(BivesSingleFileRequest.COMMAND_SINFLE_FLATTEN);
				
		// send request and get response
		BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
		BivesSingleFileResponse result = bives.performRequest(request);
		
		// anything bad happened?
		if (result.hasError ())
		{
			for (String err : result.getErrors ())
				System.err.println ("ERROR: " + err);
			System.exit (1);
		}
		
		// get the flattened model:
		//String flattenedModel = result.getResult (BivesSingleFileResponse.COMMAND_SINFLE_FLATTEN);
		//System.out.println ("flattened model is " + flattenedModel.length () + " chars");
		
		
		// what type of document is this?
		System.out.println ("this is of type " + result.getDocumentTypes ());
		
		
		// get the meta
		Map<String, String> meta = result.getMeta ();
		// available keys:
		System.out.println ("meta keys: " + meta.keySet ());
		// in cellml models we could for example ask for the model's name
		System.out.println ("model name: " + meta.get ("modelName"));

		
		// get the node stats (some statistics about the nodes int the corresponding XML document)
		Map<String, Integer> nodeStats = result.getNodeStats ();
		System.out.println ("there are " + nodeStats.get ("component") + " component nodes in the XML tree");
		
	}
	
}
