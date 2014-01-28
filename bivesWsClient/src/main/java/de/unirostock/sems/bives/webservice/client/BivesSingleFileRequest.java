/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;

import java.util.List;


/**
 * The Class BivesSingleFileRequest to retrieve some information of a single file from the BiVeS web service.
 *
 * @author martin
 */
public class BivesSingleFileRequest extends BivesRequest implements BivesSingleFileCommands
{

	/**
	 * The Constructor to create a single-file-request.
	 */
	public BivesSingleFileRequest ()
	{
		super ();
	}
	
	/**
	 * The Constructor to create a single-file-request.
	 *
	 * @param file1 the file1
	 */
	public BivesSingleFileRequest (String file1)
	{
		super ();
		models.add (file1);
	}
	
	/**
	 * The Constructor to create a single-file-request.
	 *
	 * @param file1 the file1
	 * @param commands the commands
	 */
	public BivesSingleFileRequest (String file1, List<String> commands)
	{
		super ();
		models.add (file1);
		for (String c : commands)
			commands.add (c);
	}
	
	/**
	 * Sets the model.
	 *
	 * @param file1 the model
	 */
	public void setModel (String file1)
	{
		models.clear ();
		models.add (file1);
	}
	
	/**
	 * Checks if the request is ready. (is there exactly one model and at least one command?)
	 * @see de.unirostock.sems.bives.webservice.client.BivesRequest#isReady()
	 */
	public boolean isReady ()
	{
		return models.size () == 1 && super.isReady ();
	}
	
}
