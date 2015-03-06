/**
 * 
 */
package de.unirostock.sems.bives.webservice.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.unirostock.sems.bives.webservice.client.BivesComparisonRequest;
import de.unirostock.sems.bives.webservice.client.BivesComparisonResponse;
import de.unirostock.sems.bives.webservice.client.BivesSingleFileRequest;
import de.unirostock.sems.bives.webservice.client.BivesSingleFileResponse;
import de.unirostock.sems.bives.webservice.client.BivesWs;
import de.unirostock.sems.bives.webservice.client.impl.HttpBivesClient;


/**
 * @author Martin Scharm
 *
 */
@RunWith(JUnit4.class)
public class TestForChaste
{
  /**
   * 
   */
  @Test
  public void testChastLikeCall1 ()
  {
		try
		{
			BivesComparisonRequest request = new BivesComparisonRequest();
			request.setModels ("http://budhat.sems.uni-rostock.de/download?downloadModel=27", "http://budhat.sems.uni-rostock.de/download?downloadModel=28");

			request.addCommand(BivesComparisonRequest.COMMAND_COMPONENT_HIERARCHY_JSON);
			request.addCommand(BivesComparisonRequest.COMMAND_REACTIONS_JSON);
			request.addCommand(BivesComparisonRequest.COMMAND_REPORT_HTML);
			request.addCommand(BivesComparisonRequest.COMMAND_XML_DIFF);
			
			BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
			BivesComparisonResponse result = bives.performRequest(request);
			
			//System.out.println (result.getErrors ());
			
			assertFalse ("web service client should not receive errors!", result.hasError ());
		}
		catch (Exception bce)
		{
			bce.printStackTrace ();
			fail ("wasn't able to call bives websevice: " + bce.getMessage ());
		}
  	
  }
  /**
   * 
   */
  @Test
  public void testChastLikeCall2 ()
  {
		try
		{
			BivesSingleFileRequest request = new BivesSingleFileRequest ();
			request.setModel ("http://budhat.sems.uni-rostock.de/download?downloadModel=27");

			request.addCommand(BivesSingleFileRequest.COMMAND_SINGLE_FILE_COMPONENT_HIERARCHY_JSON);
			request.addCommand(BivesSingleFileRequest.COMMAND_SINGLE_FILE_REACTIONS_JSON);
			
			BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
			BivesSingleFileResponse result = bives.performRequest(request);
			
			//System.out.println (result.getErrors ());
			
			assertFalse ("web service client should not receive errors!", result.hasError ());
		}
		catch (Exception bce)
		{
			bce.printStackTrace ();
			fail ("wasn't able to call bives websevice: " + bce.getMessage ());
		}
  	
  }
	
}
