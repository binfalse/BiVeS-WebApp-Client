package de.unirostock.sems.bivesWsClient;

import java.util.ArrayList;
import java.util.List;

public abstract class BivesRequest implements BivesStatics {

	
	protected List<String> models;
	protected List<String> commands;
	
	protected BivesRequest() {
		
		this.models = new ArrayList<String>();
		this.commands = new ArrayList<String>();
		
	}
	
	public boolean isReady ()
	{
		return commands.size () > 0;
	}
	
	public void addCommand(String command) {
		commands.add(command);
	}
	
	public List<String> getModels() {
		return models;
	}

	public List<String> getCommands() {
		return commands;
	}

	@Override
	public String toString() {
		return "BivesRequest [models=" + models + ", commands=" + commands
				+ "]";
	}
	
	
}
