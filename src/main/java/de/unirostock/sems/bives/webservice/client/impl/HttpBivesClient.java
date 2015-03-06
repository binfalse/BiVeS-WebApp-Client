package de.unirostock.sems.bives.webservice.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import de.unirostock.sems.bives.webservice.client.BivesComparisonRequest;
import de.unirostock.sems.bives.webservice.client.BivesComparisonResponse;
import de.unirostock.sems.bives.webservice.client.BivesRequest;
import de.unirostock.sems.bives.webservice.client.BivesResponse;
import de.unirostock.sems.bives.webservice.client.BivesSingleFileRequest;
import de.unirostock.sems.bives.webservice.client.BivesSingleFileResponse;
import de.unirostock.sems.bives.webservice.client.BivesWs;
import de.unirostock.sems.bives.webservice.client.exception.BivesClientException;
import de.unirostock.sems.bives.webservice.client.exception.BivesException;

/**
 * The Implementation of a BiVeS web service Client.
 */
public class HttpBivesClient implements BivesWs {

	private static final String REQUEST_FIELD_FILES = "files";
	private static final String REQUEST_FIELD_COMMANDS = "commands";

	/** The base url. */
	protected String baseUrl;

	/**
	 * The Constructor.
	 *
	 * @param baseUrl the URL to the BiVeS web service, e.g. <code>http://bives.sems.uni-rostock.de/</code>
	 */
	public HttpBivesClient( String baseUrl ) {
		this.baseUrl = baseUrl;
	}

	/**
	 * Performs the request.
	 *
	 * @param request the request for the BiVeS web service
	 * @param result the result from the BiVeS web service
	 * @throws BivesClientException the bives client exception
	 */
	protected void performRequest(BivesRequest request, BivesResponse result) throws BivesClientException {

		if( request == null || !request.isReady () )
			throw new IllegalArgumentException("The request isn't valid.");

		// generate the Request Parameter
		HttpClient httpClient = HttpClientBuilder.create().build();
		Gson gson = new Gson ();
		Map<String, JsonElement> requestJson = new HashMap<String, JsonElement>();
		requestJson.put( REQUEST_FIELD_FILES, gson.toJsonTree(request.getModels()) );
		requestJson.put( REQUEST_FIELD_COMMANDS, gson.toJsonTree(request.getCommands()) );
		String json = gson.toJson(requestJson);

		// prepare http request
		HttpPost httpRequest = new HttpPost( baseUrl );
		// adds the json
		httpRequest.setEntity( new StringEntity(json, ContentType.APPLICATION_JSON) );

		String stringResult = null;


		HttpResponse response = null;
		// Retrieving the Http Response
		try {
			response = httpClient.execute(httpRequest);

			// reads the result
			StringBuilder stringResultBuilder = new StringBuilder();
			BufferedReader resultReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			// TODO check status code
			response.getStatusLine().getStatusCode();
			
			String line = "";
			while ((line = resultReader.readLine()) != null) {
				//append              
				stringResultBuilder.append(line);
			}
			stringResult = stringResultBuilder.toString();

		} catch (ClientProtocolException e) {
			throw new BivesClientException("Protocol Exception while fetching content from the server.", e);
		} catch (IOException e) {
			throw new BivesClientException("IO Exception while fetching content from the server.", e);
		}
		
		// check for http error code
		if( response.getStatusLine().getStatusCode() != 200 )
			throw new BivesClientException( MessageFormat.format("Unexpected HttpStatus while connecting to BiVeS-WS: {0}: {1}", response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase()));
		
		if( stringResult == null || stringResult.isEmpty() )
			throw new BivesClientException("The result returned from the BiVeS Webservice is empty or null!");

//		System.out.println("Bives: " + stringResult);
		JsonObject obj = null;
		try {
			JsonParser parser = new JsonParser();
			obj = parser.parse(stringResult).getAsJsonObject ();
		}
		catch (JsonSyntaxException e) {
			throw new BivesClientException("Error while parsing the json result!", e);
		}
		
		if( obj == null )
			throw new BivesClientException("Can not parse the json result!");
		
		for (Entry<String, JsonElement> entry : obj.entrySet ())
		{
			String key = entry.getKey ();
			if (key.equals ("error"))
			{
				JsonArray array = entry.getValue ().getAsJsonArray ();
				for (JsonElement arrayElement : array)
					result.addError (arrayElement.getAsString ());
				continue;
			}
			else
				result.setResult (key, entry.getValue ().getAsString ());
		}
	}

	/* (non-Javadoc)
	 * @see de.unirostock.sems.bivesWsClient.BivesWs#performRequest(de.unirostock.sems.bivesWsClient.BivesSingleFileRequest)
	 */
	@Override
	public BivesSingleFileResponse performRequest (BivesSingleFileRequest request)
			throws BivesClientException,
			BivesException
			{
		BivesSingleFileResponse response = new BivesSingleFileResponse ();

		performRequest (request, response);
		response.postProcess ();

		return response;
			}

	/* (non-Javadoc)
	 * @see de.unirostock.sems.bivesWsClient.BivesWs#performRequest(de.unirostock.sems.bivesWsClient.BivesComparisonRequest)
	 */
	@Override
	public BivesComparisonResponse performRequest (BivesComparisonRequest request)
			throws BivesClientException,
			BivesException
			{
		BivesComparisonResponse response = new BivesComparisonResponse ();
		performRequest (request, response);
		response.postProcess ();
		return response;
			}

}
