/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;


/**
 * The Interface BivesComparisonCommands providing some static command flags for comparison of files.
 *
 * @author martin
 */
public interface BivesComparisonCommands extends BivesCommands
{
	
	/** get the diff encoded in xml */
	public static final String COMMAND_XML_DIFF = "xmlDiff";
	
	// reaction network
	/** get the reaction network encoded in GraphML */
	public static final String COMMAND_REACTIONS_GRAPHML = "reactionsGraphml";
	
	/** get the reaction network encoded in DOT */
	public static final String COMMAND_REACTIONS_DOT = "reactionsDot";
	
	/** get the reaction network encoded in JSON */
	public static final String COMMAND_REACTIONS_JSON = "reactionsJson";
	
	// report
	/** get the human readable report encoded in HTML */
	public static final String COMMAND_REPORT_HTML = "reportHtml";
	
	/** get the human readable report encoded in MarkDown */
	public static final String COMMAND_REPORT_MARKDOWN = "reportMd";
	
	/** get the human readable report encoded in reStructuredText */
	public static final String COMMAND_REPORT_RESTRUCTURED_TEXT = "reportRST";
	
	// hierarchy
	/** get the component hierarchy encoded in GraphML (only available for CellML files) */
	public static final String COMMAND_COMPONENT_HIERARCHY_GRAPHML = "compHierarchyGraphml";
	
	/** get the component hierarchy encoded in DOT (only available for CellML files) */
	public static final String COMMAND_COMPONENT_HIERARCHY_DOT = "compHierarchyDot";
	
	/** get the component hierarchy encoded in JSON (only available for CellML files) */
	public static final String COMMAND_COMPONENT_HIERARCHY_JSON = "compHierarchyJson";
	
}
