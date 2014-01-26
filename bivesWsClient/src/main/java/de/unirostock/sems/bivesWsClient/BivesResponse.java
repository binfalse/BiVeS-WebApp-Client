package de.unirostock.sems.bivesWsClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class BivesResponse representing the response from a BiVeS web service.
 */
public abstract class BivesResponse implements Serializable, BivesCommands {
	
	private static final long serialVersionUID = -2807954477215637789L;
	protected Map<String, String> bivesResults;
	
	/** The errors. */
	protected List<String> error;

	/**
	 * The Constructor to create an BiVeS web service response.
	 */
	public BivesResponse() {
		this.error = new ArrayList<String> ();
		this.bivesResults = new HashMap<String, String> ();
	}
	
	/**
	 * Post process a response.
	 */
	public abstract void postProcess ();

	/**
	 * Gets a result. Might return null or an empty string if certain result not requested or not available.
	 *
	 * @param key the command
	 * @return the result
	 * @see de.unirostock.sems.bivesWsClient.BivesCommands
	 * @see de.unirostock.sems.bivesWsClient.BivesComparisonCommands
	 * @see de.unirostock.sems.bivesWsClient.BivesSingleFileCommands
	 * 
	 */
	public String getResult (String key)
	{
		return bivesResults.get (key);
	}

	/**
	 * Sets a result.
	 *
	 * @param key the command
	 * @param value the result
	 */
	public void setResult (String key, String value)
	{
		bivesResults.put (key, value);
	}
	
	/**
	 * Checks for errors.
	 *
	 * @return true, if there are errors
	 */
	public boolean hasError ()
	{
		return !error.isEmpty ();
	}
	
	/**
	 * Adds an error.
	 *
	 * @param error the error
	 */
	public void addError (String error)
	{
		this.error.add (error);
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<String> getErrors() {
		return error;
	}

}
