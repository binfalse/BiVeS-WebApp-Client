/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;


/**
 * The Interface BivesSingleFileCommands providing some static command flags to get information about certain files.
 *
 * @author martin
 */
public interface BivesSingleFileCommands extends BivesCommands
{
	
	/** get the document type of the file */
	public static final String COMMAND_DOCUMENT_TYPE = "documentType";
	
	/** get some meta information about the file */
	public static final String COMMAND_META = "meta";
	
	// reaction network
	/** get the reaction network encoded in GraphML */
	public static final String COMMAND_SINGLE_FILE_REACTIONS_GRAPHML = "singleReactionsGraphml";
	
	/** get the reaction network encoded in DOT */
	public static final String COMMAND_SINGLE_FILE_REACTIONS_DOT = "singleReactionsDot";
	
	/** get the reaction network encoded in JSON */
	public static final String COMMAND_SINGLE_FILE_REACTIONS_JSON = "singleReactionsJson";
	
	// hierarchy
	/** get the component hierarchy encoded in GraphML (only available for CellML files) */
	public static final String COMMAND_SINGLE_FILE_COMPONENT_HIERARCHY_GRAPHML = "singleCompHierarchyGraphml";
	
	/** get the component hierarchy encoded in DOT (only available for CellML files) */
	public static final String COMMAND_SINGLE_FILE_COMPONENT_HIERARCHY_DOT = "singleCompHierarchyDot";
	
	/** get the component hierarchy encoded in JSON (only available for CellML files) */
	public static final String COMMAND_SINGLE_FILE_COMPONENT_HIERARCHY_JSON = "singleCompHierarchyJson";
	
	/** get the flattened model */
	public static final String COMMAND_SINGLE_FLATTEN = "singleFlatten";
	
}
