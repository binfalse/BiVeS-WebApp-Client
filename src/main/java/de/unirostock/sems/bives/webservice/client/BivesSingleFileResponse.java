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
	 * Instantiates a new bives single file response.
	 */
	public BivesSingleFileResponse() {
		super();
		this.meta = new HashMap<String, String> ();
		this.documentTypes = new ArrayList<String> ();
		this.nodeStats = new HashMap<String, Integer> ();
	}
	
	
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
	 * Sets the meta informations.
	 *
	 * @param key the identify for the meta information
	 * @param value the meta information to set
	 */
	public void setMeta (String key, String value)
	{
		meta.put(key, value);
	}
	
	/**
	 * Sets the statistics for a certain node type.
	 * 
	 * Statistics being the number of occurences of this node in the document.
	 *
	 * @param tag the tag name of the node
	 * @param occurences the number of nodes in the document that share this tag name
	 */
	public void setNodeStats (String tag, int occurences)
	{
		nodeStats.put(tag, occurences);
	}
	
	/**
	 * Gets the node statistics as a map: NODE_NAME =&gt; OCCURRENCES.
	 *
	 * @return the node statistics
	 */
	public HashMap<String, Integer> getNodeStats ()
	{
		return nodeStats;
	}
	
	/**
	 * Adds another document type to the list of document types.
	 * 
	 * @param documentType the new document type that applies to the document
	 *
	 */
	public void addDocumentType (String documentType)
	{
		this.documentTypes.add(documentType);
	}
	
	/**
	 * Sets the document types.
	 * 
	 * This will overwrite the existing list of document types.
	 * 
	 * @param documentTypes the list of document types that apply to the document
	 *
	 */
	public void setDocumentTypes (List<String> documentTypes)
	{
		this.documentTypes = documentTypes;
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
		// nothing special to do
	}
	
}
