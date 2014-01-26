package de.unirostock.sems.bivesWsClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.unirostock.sems.bivesWsClient.impl.HttpBivesClient;

/**
 * The Class BivesWsTest to test the coded stuff.
 */
@RunWith(JUnit4.class)
public class BivesWsTest {

  /**
   * Test if errors are caught correctly.
   */
  @Test
  public void testError ()
  {
		try
		{
			BivesComparisonRequest request = new BivesComparisonRequest();
			request.setModels ("http://bives.sems.uni-rostock.de/", "http://bives.sems.uni-rostock.de/");
	
			request.addCommand(BivesComparisonRequest.COMMAND_REPORT_MARKDOWN);
			request.addCommand(BivesComparisonRequest.COMMAND_CRN_JSON);
			request.addCommand(BivesComparisonRequest.COMMAND_FORCE_SBML);
			
			BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
			BivesComparisonResponse result = bives.performRequest(request);
			
			assertTrue ("web service client should receive some errors!", result.hasError ());
			assertTrue ("web service client should receive at least one error!", 0 < result.getErrors ().size ());
		}
		catch (Exception bce)
		{
			bce.printStackTrace ();
			fail ("wasn't able to call bives websevice: " + bce.getMessage ());
		}
  	
  }

  
	/**
	 * Test what happens if server is broken.
	 */
	@Test
	public void testBrokenServer () {
		try
		{
			BivesComparisonRequest request = new BivesComparisonRequest();
			request.setModels ("http://budhat.sems.uni-rostock.de/download?downloadModel=25", "http://budhat.sems.uni-rostock.de/download?downloadModel=24");
	
			request.addCommand(BivesComparisonRequest.COMMAND_REPORT_MARKDOWN);
			request.addCommand(BivesComparisonRequest.COMMAND_CRN_JSON);

			BivesWs bives = new HttpBivesClient("http://sems.uni-rostock.de/");
			bives.performRequest(request);
			fail ("bives web client is able to speak to a broken server!?");
		}
		catch (Exception bce)
		{
		}
	}

  
	/**
	 * Test single file request.
	 */
	@Test
	public void testSingleFile() {
		try
		{
			BivesSingleFileRequest request = new BivesSingleFileRequest("http://budhat.sems.uni-rostock.de/download?downloadModel=24");
	
			request.addCommand(BivesSingleFileRequest.COMMAND_DOCUMENT_TYPE);
			request.addCommand(BivesSingleFileRequest.COMMAND_FORCE_SBML);
			request.addCommand(BivesSingleFileRequest.COMMAND_META);
			request.addCommand(BivesSingleFileRequest.COMMAND_SINFLE_FILE_CRN_JSON);

			BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
			BivesSingleFileResponse result = bives.performRequest(request);
			
			assertNotNull ("response for "+BivesSingleFileResponse.COMMAND_DOCUMENT_TYPE+" shouldn't be null ", result.getDocumentTypes ());
			assertEquals ("response for "+BivesSingleFileResponse.COMMAND_DOCUMENT_TYPE+" should be XML,SBML", 2, result.getDocumentTypes ().size ());
			
			assertNotNull ("response for "+BivesSingleFileResponse.COMMAND_META+" shouldn't be null ", result.getMeta ());
			assertNotNull ("response for "+BivesSingleFileResponse.COMMAND_META+" [sbmlVersion] shouldn't be null ", result.getMeta ().get ("sbmlVersion"));
			assertTrue ("response for "+BivesSingleFileResponse.COMMAND_META+" [sbmlVersion] shouldn't be empty", result.getMeta ().get ("sbmlVersion").length () > 0);
			
			assertNotNull ("response for "+BivesSingleFileResponse.COMMAND_META+" [nodestats] shouldn't be null ", result.getNodeStats ());
			assertTrue ("response for "+BivesSingleFileResponse.COMMAND_META+" [nodestats] shouldn't be empty", result.getNodeStats ().size () > 0);

			assertNotNull ("response for "+BivesSingleFileResponse.COMMAND_SINFLE_FILE_CRN_JSON+" shouldn't be null ", result.getResult (BivesSingleFileResponse.COMMAND_SINFLE_FILE_CRN_JSON));
			assertTrue ("response for "+BivesSingleFileResponse.COMMAND_SINFLE_FILE_CRN_JSON+" shouldn't be empty", result.getResult (BivesSingleFileResponse.COMMAND_SINFLE_FILE_CRN_JSON).length () > 0);
		}
		catch (Exception bce)
		{
			bce.printStackTrace ();
			fail ("wasn't able to call bives websevice: " + bce.getMessage ());
		}
	}

  
	/**
	 * Test comparison request.
	 */
	@Test
	public void testComparison() {
		try
		{
			BivesComparisonRequest request = new BivesComparisonRequest();
			request.setModels ("http://budhat.sems.uni-rostock.de/download?downloadModel=25", "http://budhat.sems.uni-rostock.de/download?downloadModel=24");
	
			request.addCommand(BivesComparisonRequest.COMMAND_REPORT_MARKDOWN);
			request.addCommand(BivesComparisonRequest.COMMAND_CRN_JSON);

			BivesWs bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
			BivesComparisonResponse result = bives.performRequest(request);
			
			assertNotNull ("response for "+BivesComparisonResponse.COMMAND_REPORT_MARKDOWN+" shouldn't be null ", result.getResult (BivesComparisonResponse.COMMAND_REPORT_MARKDOWN));
			assertTrue ("response for "+BivesComparisonResponse.COMMAND_REPORT_MARKDOWN+" shouldn't be empty", result.getResult (BivesComparisonResponse.COMMAND_REPORT_MARKDOWN).length () > 0);
			
			assertNotNull ("response for "+BivesComparisonResponse.COMMAND_CRN_JSON+" shouldn't be null ", result.getResult (BivesComparisonResponse.COMMAND_CRN_JSON));
			assertTrue ("response for "+BivesComparisonResponse.COMMAND_CRN_JSON+" shouldn't be empty", result.getResult (BivesComparisonResponse.COMMAND_CRN_JSON).length () > 0);
			
			assertNull ("response for "+BivesComparisonResponse.COMMAND_CRN_DOT +" should be null ", result.getResult (BivesComparisonResponse.COMMAND_CRN_DOT));
		}
		catch (Exception bce)
		{
			bce.printStackTrace ();
			fail ("wasn't able to call bives websevice: " + bce.getMessage ());
		}
	}
}
