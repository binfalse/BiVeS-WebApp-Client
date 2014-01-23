/**
 * 
 */
package de.unirostock.sems.bivesWsClient;


/**
 * @author martin
 *
 */
public interface BivesSingleFileStatics extends BivesStatics
{
	public static final String COMMAND_DOCUMENT_TYPE = "documentType";
	public static final String COMMAND_META = "meta";
	// crn
	public static final String COMMAND_SINGLE_FILE_CRN_GRAPHML = "singleCrnGraphml";
	public static final String COMMAND_SINGLE_FILE_CRN_DOT = "singleCrnDot";
	public static final String COMMAND_SINFLE_FILE_CRN_JSON = "singleCrnJson";
	// hierarchy
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_GRAPHML = "singleCompHierarchyGraphml";
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_DOT = "singleCompHierarchyDot";
	public static final String COMMAND_SINFLE_FILE_COMPONENT_HIERARCHY_JSON = "singleCompHierarchyJson";
	
}
