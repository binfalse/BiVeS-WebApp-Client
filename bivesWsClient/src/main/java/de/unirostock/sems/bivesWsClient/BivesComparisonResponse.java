/**
 * 
 */
package de.unirostock.sems.bivesWsClient;


/**
 * The Class BivesComparisonResponse representing a response of a comparison request sent to the BiVeS web service.
 *
 * @author martin
 */
public class BivesComparisonResponse extends BivesResponse implements BivesComparisonCommands
{
	private static final long	serialVersionUID	= 2161684121628587034L;

	/* (non-Javadoc)
	 * @see de.unirostock.sems.bivesWsClient.BivesResponse#postProcess()
	 */
	@Override
	public void postProcess ()
	{
		// nothing special to do
	}
	
}
