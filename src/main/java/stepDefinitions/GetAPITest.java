package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class GetAPITest  extends TestBase{
	private static final String NULL = null;
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	
	@Given("^Loan Market broker is on the validate API$")
	public void setUp() {
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl + apiUrl;
		
	}
	
	@When("^the user enter valid details$")
	public void click()
	{
		System.out.print("Userthe user enter valid details ");
		System.out.print("\n");
	}
	
	
	
	@When("^the user enter invalid details$")
	public void details()
	{
		System.out.print("Userthe user enter invalid details ");
		System.out.print("\n");
	}
	
	

	@Then("^the validation should be successfull$")
	public void enterdetails()
	{System.out.print("status codeis coming 200");
	System.out.print("\n");
	}
	
	
	@Then("^the validation should not be successfull$")
	public void enterinvaliddetails()
	{
		System.out.print("status code is coming 400");
	System.out.print("\n");
	}
	
	
	
	
	public void getAPITestWithoutHeaders(int statuscode) throws ClientProtocolException, IOException{
		restClient = new RestClient();
		closebaleHttpResponse = restClient.get(url);
		
		//a. Status Code:
		int statusCode1 = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode1);
		//json = response.then().statusCode(statusCode);
		Assert.assertEquals(statusCode1, RESPONSE_STATUS_CODE_200, "Status code is not 200");

		//b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API------> "+ responseJson);
	
		Header[] headersArray =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();	
		for(Header header : headersArray){
			allHeaders.put(header.getName(), header.getValue());
		}	
		System.out.println("Headers Array-->"+allHeaders);
		
		}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@And ("^the status code should be 200$")
	public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException{
		
	restClient = new RestClient();
	HashMap<String, String> headerMap = new HashMap<String, String>();
	headerMap.put("Content-Type", "application/json");
	headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
	
	
	//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("morpheus", "leader"); //expected users obejct
		
		//object to json file:
		mapper.writeValue(new File("/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/users.json"), users);
		
		//java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		
		closebaleHttpResponse = restClient.post(url, usersJsonString, headerMap); //call the API
		
		//validate response from API:
		//1. status code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);
		
		//2. JsonString:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("The response from API is:"+ responseJson);
		
		//json to java object:
	/*	Users usersResObj = mapper.readValue(responseString, Users.class); //actual users object
		System.out.println(usersResObj);*/


}
	

	@And ("^the status code should come 400$")
	public void errormessage() throws JsonGenerationException, JsonMappingException, IOException
	{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
		
		
		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("morpheus", "leader"); //expected users object
		
		//object to json file:
		mapper.writeValue(new File("/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/users2.json"), users);
		
		//java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		
		closebaleHttpResponse = restClient.post(url, usersJsonString, headerMap); //call the API
		
		//validate response from API:
		//1. status code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);
		
		//2. JsonString:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("The response from API is:"+ responseJson);
		
		//json to java object:
	/*	Users usersResObj = mapper.readValue(responseString, Users.class); //actual users object
		System.out.println(usersResObj);*/
	}
	
}
