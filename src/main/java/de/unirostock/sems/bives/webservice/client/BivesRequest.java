package de.unirostock.sems.bives.webservice.client;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class BivesRequest to create a request for the BiVeS web service.
 */
public abstract class BivesRequest implements BivesCommands {

	
	protected List<String> models;
	protected List<String> commands;
	
	/**
	 * Instantiate a new request.
	 */
	protected BivesRequest() {
		
		this.models = new ArrayList<String>();
		this.commands = new ArrayList<String>();
		
	}
	
	/**
	 * Checks if is this request is ready. (at least one command?)
	 *
	 * @return true, if the request is ready to get sent
	 */
	public boolean isReady ()
	{
		return commands.size () > 0;
	}
	
	/**
	 * Adds another command.
	 *
	 * @param command the command
	 * @see de.unirostock.sems.bives.webservice.client.BivesCommands
	 * @see de.unirostock.sems.bives.webservice.client.BivesComparisonCommands
	 * @see de.unirostock.sems.bives.webservice.client.BivesSingleFileCommands
	 */
	public void addCommand(String command) {
		commands.add(command);
	}
	
	/**
	 * Gets the models.
	 *
	 * @return the models
	 */
	public List<String> getModels() {
		return models;
	}

	/**
	 * Gets the commands.
	 *
	 * @return the commands
	 */
	public List<String> getCommands() {
		return commands;
	}
	
	
}
