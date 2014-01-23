/**
 * 
 */
package de.unirostock.sems.bivesWsClient;

import java.util.List;


/**
 * @author martin
 *
 */
public class BivesComparisonRequest extends BivesRequest implements BivesComparisonStatics
{

	public BivesComparisonRequest ()
	{
		super ();
	}
	
	public BivesComparisonRequest (String file1, String file2)
	{
		super ();
		models.add (file1);
		models.add (file2);
	}
	
	public BivesComparisonRequest (String file1, String file2, List<String> commands)
	{
		super ();
		models.add (file1);
		models.add (file2);
		for (String c : commands)
			commands.add (c);
	}
	
	public void setModels (String file1, String file2)
	{
		models.clear ();
		models.add (file1);
		models.add (file2);
	}
	
	public boolean isReady ()
	{
		return models.size () == 2 && super.isReady ();
	}
	
}
