/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;


/**
 * The Interface BivesCommands providing some static command flags.
 *
 * @author martin
 */
public interface BivesCommands
{
	/** force SBML file interpretation */
	public static final String COMMAND_FORCE_SBML = "SBML";
	
	/** force CellML file interpretation */
	public static final String COMMAND_FORCE_CELLML = "CellML";
	
	/** force regular file interpretation (don't try to read as SBML or CellML) */
	public static final String COMMAND_FORCE_REGULAR = "regular";
	
	/** just intended to help server administrators to fix problems */
	public static final String COMMAND_SET_VERBOSE = "verbose";
	/** just intended to help server administrators to fix issues */
	public static final String COMMAND_SET_LOG_STACKTRACE = "stacktrace";
}
