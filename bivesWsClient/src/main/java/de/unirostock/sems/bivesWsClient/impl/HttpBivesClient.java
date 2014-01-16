package de.unirostock.sems.bivesWsClient.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import de.unirostock.sems.bivesWsClient.BivesRequest;
import de.unirostock.sems.bivesWsClient.BivesResult;
import de.unirostock.sems.bivesWsClient.BivesWs;
import de.unirostock.sems.bivesWsClient.exception.BivesClientException;
import de.unirostock.sems.bivesWsClient.exception.BivesException;

public class HttpBivesClient implements BivesWs {

	private static final String REQUEST_FIELD_FILES = "files";

	private static final String REQUEST_FIELD_COMMANDS = "get";

	protected String baseUrl;

	protected Gson gson;
	protected HttpClient httpClient;
	
	private Type bivesResultType;
	private Type bivesErrorResult;

	public HttpBivesClient( String baseUrl ) {
		this.baseUrl = baseUrl;

		// creates Framework instances
		gson = new Gson();
		httpClient = HttpClientBuilder.create().build();
		
		bivesResultType = new TypeToken<BivesResult>(){}.getType();
		bivesErrorResult = new TypeToken<BivesErrorResult>(){}.getType();
	}

	public BivesResult performRequest(BivesRequest request) throws BivesClientException, BivesException {

		if( request == null )
			throw new IllegalArgumentException("The request Url should not be null!");

		// generate the Request Parameter
		Map<String, JsonElement> requestJson = new HashMap<String, JsonElement>();
		requestJson.put( REQUEST_FIELD_FILES, gson.toJsonTree(request.getModels()) );
		requestJson.put( REQUEST_FIELD_COMMANDS, gson.toJsonTree(request.getCommands()) );
		String json = gson.toJson(requestJson);

		// prepare http request
		HttpPost httpRequest = new HttpPost( baseUrl );
		// adds the json
		httpRequest.setEntity( new StringEntity(json, ContentType.APPLICATION_JSON) );

		String stringResult = null;
		
		// Retrieving the Http Response
		try {
			HttpResponse response = httpClient.execute(httpRequest);

			// reads the result
			StringBuilder stringResultBuilder = new StringBuilder();
			BufferedReader resultReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = resultReader.readLine()) != null) {
				//append              
				stringResultBuilder.append(line);
			}
			stringResult = stringResultBuilder.toString();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( stringResult == null || stringResult.isEmpty() )
			throw new BivesClientException("The result returned from the BiVeS Webservice is empty or null!");
		
		BivesResult result = null;
		
		// Marshall the response into java dataholder
		try {
			result = gson.fromJson(stringResult, bivesResultType);
		} catch (JsonSyntaxException e1) {
			
			try {
				BivesErrorResult errorResult = gson.fromJson(stringResult, bivesErrorResult);
				
				if( errorResult != null ) 
					throw new BivesException( MessageFormat.format("The request produced multiple error: {0}", errorResult.getErrorText()), e1 );
				else
					throw new BivesException( "The result could not parsed normally, but the error message was null.", e1 );
				
			} catch (JsonSyntaxException e2) {
				throw new BivesException("Not even the error message could be parsed", e2);
			}
		}

		return result;
	}
	
	protected class BivesErrorResult {
		private List<String> error;

		public BivesErrorResult(List<String> error) {
			super();
			this.error = error;
		}

		public List<String> getError() {
			return error;
		}

		public void setError(List<String> error) {
			this.error = error;
		}
		
		public String getErrorText() {
//			StringBuilder result = new StringBuilder();
//			
//			for( String line : error ) {
//				result.append(line);
//				result.append(", ");
//			}
//				
//			return result.substring(0, result.length()-2);
			return error.toString();
		}
		
		
	}
	
}
