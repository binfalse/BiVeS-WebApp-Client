/**
 * 
 */
package de.unirostock.sems.bivesWsClient;

import java.util.List;


/**
 * The Class BivesComparisonRequest to compare two versions using BiVeS web service.
 *
 * @author martin
 */
public class BivesComparisonRequest extends BivesRequest implements BivesComparisonCommands
{

	/**
	 * The Constructor to create a comparison request.
	 */
	public BivesComparisonRequest ()
	{
		super ();
	}
	
	/**
	 * The Constructor to create a comparison request.
	 *
	 * @param file1 the version one
	 * @param file2 the version two
	 */
	public BivesComparisonRequest (String file1, String file2)
	{
		super ();
		models.add (file1);
		models.add (file2);
	}
	
	/**
	 * The Constructor to create a comparison request.
	 *
	 * @param file1 the version one
	 * @param file2 the version two
	 * @param commands the commands to send
	 */
	public BivesComparisonRequest (String file1, String file2, List<String> commands)
	{
		super ();
		models.add (file1);
		models.add (file2);
		for (String c : commands)
			commands.add (c);
	}
	
	/**
	 * Sets the models.
	 *
	 * @param file1 the version one
	 * @param file2 the version two
	 */
	public void setModels (String file1, String file2)
	{
		models.clear ();
		models.add (file1);
		models.add (file2);
	}
	
	/**
	 * Checks if the request is ready. (are there exactly two models and at least one command?)
	 * 
	 * @see de.unirostock.sems.bivesWsClient.BivesRequest#isReady()
	 */
	public boolean isReady ()
	{
		return models.size () == 2 && super.isReady ();
	}
	
}
