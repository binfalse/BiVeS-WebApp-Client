/**
 * 
 */
package de.unirostock.sems.bivesWsClient;

import java.util.List;


/**
 * @author martin
 *
 */
public class BivesSingleFileRequest extends BivesRequest implements BivesSingleFileStatics
{

	public BivesSingleFileRequest ()
	{
		super ();
	}
	
	public BivesSingleFileRequest (String file1)
	{
		super ();
		models.add (file1);
	}
	
	public BivesSingleFileRequest (String file1, List<String> commands)
	{
		super ();
		models.add (file1);
		for (String c : commands)
			commands.add (c);
	}
	
	public void setModel (String file1)
	{
		models.clear ();
		models.add (file1);
	}
	
	public boolean isReady ()
	{
		return models.size () == 1 && super.isReady ();
	}
	
}
