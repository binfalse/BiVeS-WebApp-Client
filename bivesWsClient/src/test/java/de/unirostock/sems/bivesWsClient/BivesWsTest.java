package de.unirostock.sems.bivesWsClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.unirostock.sems.bivesWsClient.exception.BivesClientException;
import de.unirostock.sems.bivesWsClient.exception.BivesException;
import de.unirostock.sems.bivesWsClient.impl.HttpBivesClient;

@RunWith(JUnit4.class)
public class BivesWsTest {
	
	private BivesWs bives;
	
	@Before
	public void prepare() {
		bives = new HttpBivesClient("http://bives.sems.uni-rostock.de/");
	}
	
	@Test
	public void test1() throws BivesClientException, BivesException {
		
		BivesRequest request = new BivesRequest();
		request.addModel("model1", "http://budhat.sems.uni-rostock.de/download?downloadModel=25");
		request.addModel("model2", "http://budhat.sems.uni-rostock.de/download?downloadModel=24");
		
		request.addCommand(BivesRequest.COMMAND_REPORT_MD);
		request.addCommand(BivesRequest.COMMAND_DOCUMENT_TYPE);
		request.addCommand(BivesRequest.COMMAND_META);
		
		BivesResult result = bives.performRequest(request);
		System.out.println(result);
		
	}
}
