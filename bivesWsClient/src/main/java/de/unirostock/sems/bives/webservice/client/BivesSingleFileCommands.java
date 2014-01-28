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
	
	// crn
	/** get the chemical reation network encoded in GraphML */
	public static final String COMMAND_SINGLE_FILE_CRN_GRAPHML = "singleCrnGraphml";
	
	/** get the chemical reation network encoded in DOT */
	public static final String COMMAND_SINGLE_FILE_CRN_DOT = "singleCrnDot";
	
	/** get the chemical reation network encoded in JSON */
	public static final String COMMAND_SINFLE_FILE_CRN_JSON = "singleCrnJson";
	
	// hierarchy
	/** get the component hierarchy encoded in GraphML (only available for CellML files) */
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_GRAPHML = "singleCompHierarchyGraphml";
	
	/** get the component hierarchy encoded in DOT (only available for CellML files) */
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_DOT = "singleCompHierarchyDot";
	
	/** get the component hierarchy encoded in JSON (only available for CellML files) */
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_JSON = "singleCompHierarchyJson";
	
}
