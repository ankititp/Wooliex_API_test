package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.qa.base.TestBase;
import com.qa.client.RestClient;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.JSONParser;



public class GetAPITest extends TestBase
{
	private static final String NULL = null;
	private static final String JsonArray = null;
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	
	@Given("^I like to holiday in Sydney$")
	public void setUp() {
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl + apiUrl;
		
		
	}
	
	@When("^I look up the weather forecast$")
	public void enter_valid_details()
	{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
	}
	
	
	
	@Then("^I receive the weather forecast$")
	public void  recieve_forecast() throws ClientProtocolException, IOException
	{
	
			CloseableHttpResponse response = restClient.get(url);
			System.out.print("\n");
			int statusCode = response.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);
	}
	
	

	@And ("^the temperature is warmer than 10 degrees$")
	public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException{
		
		CloseableHttpResponse response = restClient.get(url);
		//2. JsonString:
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		  JSONObject responseJson = new JSONObject(responseString);  
		System.out.println("The response from API is:"+ responseJson);
		System.out.println("-------------------------------------");
			
		  JSONArray jsonArray=responseJson.getJSONArray("list");
		  
		  JSONParser json=new JSONParser(null, null);
		  
		  for(int i=0; i<jsonArray.length();i++){
			  JSONObject jso = jsonArray.getJSONObject(i);
			  System.out.println(jso.getInt("list"));
			  int value = jso.getInt("temp");
			  
			 // System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
			  
	
			  if (value>10)
			  System.out.println("Holidaymaker can go and enjoy sydney");
			  else
			  System.out.println("Temperature is less than 10, so better to rest in hotel");
	
			}
		  
	}
}
	
