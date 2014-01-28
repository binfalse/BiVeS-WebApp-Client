/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The Class BivesSingleFileResponse representing a response of a single-file-request sent to the BiVeS web service.
 *
 * @author martin
 */
public class BivesSingleFileResponse extends BivesResponse implements BivesSingleFileCommands
{
	private static final long	serialVersionUID	= -5594048578870894606L;
	
	/** The meta informations. */
	protected HashMap<String, String> meta;
	
	/** The node statistics. */
	protected HashMap<String, Integer> nodeStats;
	
	/** The document types. */
	protected List<String> documentTypes;
	
	/**
	 * Gets the meta informations.
	 *
	 * @return the meta
	 */
	public HashMap<String, String> getMeta ()
	{
		return meta;
	}
	
	/**
	 * Gets the node statistics as a map: NODE_NAME => OCCURRENCES.
	 *
	 * @return the node statistics
	 */
	public HashMap<String, Integer> getNodeStats ()
	{
		return nodeStats;
	}
	
	/**
	 * Gets the document types.
	 *
	 * @return the document types
	 */
	public List<String> getDocumentTypes ()
	{
		return documentTypes;
	}
	
	/* (non-Javadoc)
	 * @see de.unirostock.sems.bivesWsClient.BivesResponse#postProcess()
	 */
	@Override
	public void postProcess ()
	{
		// parse meta stuff
		String meta = bivesResults.get (COMMAND_META);
		if (meta != null)
		{
			this.meta = new HashMap<String, String> ();
			String [] tokens = meta.split (";");
			for (String token : tokens)
			{
				if (token.length () < 3)
					continue;
				String [] kv = token.split (":");
				if (kv.length != 2)
					continue;
				
				if (kv[0].equals ("nodestats"))
				{
					this.nodeStats = new HashMap<String, Integer> ();
					String [] stats = kv[1].substring (1, kv[1].length () - 1).split (",");
					for (String stat : stats)
					{
						if (stat.length () < 3)
							continue;
						String [] kv2 = stat.split ("=");
						if (kv2.length != 2)
							continue;
						this.nodeStats.put (kv2[0], Integer.parseInt (kv2[1]));
					}
				}
				else
					this.meta.put (kv[0], kv[1]);
			}
			bivesResults.remove (COMMAND_META);
		}
		
		String docTypes = bivesResults.get (COMMAND_DOCUMENT_TYPE);
		if (docTypes != null)
		{
			this.documentTypes = new ArrayList<String> ();
			
			String [] dT = docTypes.split (",");
			for (String dt : dT)
				if (dt.length () > 0)
					this.documentTypes.add (dt);
			
			bivesResults.remove (COMMAND_DOCUMENT_TYPE);
		}
		
	}
	
}
