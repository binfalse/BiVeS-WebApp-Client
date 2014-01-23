/**
 * 
 */
package de.unirostock.sems.bivesWsClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author martin
 *
 */
public class BivesSingleFileResponse extends BivesResponse implements BivesSingleFileStatics
{
	private static final long	serialVersionUID	= -5594048578870894606L;
	protected HashMap<String, String> meta;
	protected HashMap<String, Integer> nodeStats;
	protected List<String> documentTypes;

	public String debug ()
	{
		StringBuilder sb = new StringBuilder ();
		for (String s : bivesResults.keySet ())
			sb.append (s + "=" + bivesResults.get (s) + ";");
		return sb.toString ();
	}
	
	public HashMap<String, String> getMeta ()
	{
		return meta;
	}
	
	public HashMap<String, Integer> getNodeStats ()
	{
		return nodeStats;
	}
	
	public List<String> getDocumentTypes ()
	{
		return documentTypes;
	}
	
	@Override
	public void prostProcess ()
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
