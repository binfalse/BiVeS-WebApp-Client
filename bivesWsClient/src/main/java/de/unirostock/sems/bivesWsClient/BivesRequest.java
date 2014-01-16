package de.unirostock.sems.bivesWsClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BivesRequest {
	
	public static final String COMMAND_DOCUMENT_TYPE = "documentType";
	public static final String COMMAND_META = "meta";
	public static final String COMMAND_XML_DIFF = "xmlDiff";
	public static final String COMMAND_CRN_GRAPHML = "crnGraphml";
	public static final String COMMAND_CRN_DOT = "crnDot";
	public static final String COMMAND_REPORT_HTML = "reportHtml";
	public static final String COMMAND_REPORT_MD = "reportMd";
	public static final String COMMAND_COMP_HIERARCHY_GRAPHML = "compHierarchyGraphml";
	public static final String COMMAND_COMP_HIERARCHY_DOT = "compHierarchyDot";
	
	private Map<String, String> models;
	private List<String> commands;
	
	public BivesRequest( Map<String, String> models, List<String> commands ) {
		
		if( models != null )
			this.models = models;
		else
			this.models = new HashMap<String, String>();
		
		if( commands != null )
			this.commands = commands;
		else
			this.commands = new ArrayList<String>();
		
	}
	
	public BivesRequest( Map<String, String> models ) {
		this(models, null);
	}
	
	public BivesRequest() {
		this(null, null);
	}
	
	public void addCommand(String command) {
		commands.add(command);
	}
	
	public void addModel( String id, String model ) {
		models.put(id, model);
	}
	
	public Map<String, String> getModels() {
		return models;
	}

	public List<String> getCommands() {
		return commands;
	}
	
	
}
