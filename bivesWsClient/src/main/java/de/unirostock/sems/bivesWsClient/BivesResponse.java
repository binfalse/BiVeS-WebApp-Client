package de.unirostock.sems.bivesWsClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BivesResponse implements Serializable, BivesStatics {
	
	private static final long serialVersionUID = -2807954477215637789L;
	
	protected Map<String, String> bivesResults;
	
	// TODO: test errors
	protected List<String> error;

	public BivesResponse() {
		this.error = new ArrayList<String> ();
		this.bivesResults = new HashMap<String, String> ();
	}
	
	public abstract void prostProcess ();

	public String getResult (String key)
	{
		return bivesResults.get (key);
	}

	public void setResult (String key, String value)
	{
		bivesResults.put (key, value);
	}
	
	public boolean hasError ()
	{
		return !error.isEmpty ();
	}
	
	public void addError (String error)
	{
		this.error.add (error);
	}

	public List<String> getErrors() {
		return error;
	}

}
