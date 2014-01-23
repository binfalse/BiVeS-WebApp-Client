/**
 * 
 */
package de.unirostock.sems.bivesWsClient;


/**
 * @author martin
 *
 */
public interface BivesComparisonStatics extends BivesStatics
{
	public static final String COMMAND_XML_DIFF = "xmlDiff";
	// crn
	public static final String COMMAND_CRN_GRAPHML = "crnGraphml";
	public static final String COMMAND_CRN_DOT = "crnDot";
	public static final String COMMAND_CRN_JSON = "crnJson";
	// report
	public static final String COMMAND_REPORT_HTML = "reportHtml";
	public static final String COMMAND_REPORT_MARKDOWN = "reportMd";
	public static final String COMMAND_REPORT_RESTRUCTURED_TEXT = "reportRST";
	// hierarchy
	public static final String COMMAND_COMPONENT_HIERARCHY_GRAPHML = "compHierarchyGraphml";
	public static final String COMMAND_COMPONENT_HIERARCHY_DOT = "compHierarchyDot";
	public static final String COMMAND_COMPONENT_HIERARCHY_JSON = "compHierarchyJson";
	
}
