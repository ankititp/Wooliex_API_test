//package stepDefinitions;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.apache.http.Header;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.testng.Assert;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.qa.base.TestBase;
//import com.qa.client.RestClient;
//import com.qa.util.Users;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import gherkin.JSONParser;
//
//
//
//public class ErrorMessageValidation extends TestBase
//{
//	private static final String NULL = null;
//	private static final String JsonArray = null;
//	TestBase testBase;
//	String serviceUrl;
//	String apiUrl;
//	String url;
//	RestClient restClient;
//	CloseableHttpResponse closebaleHttpResponse;
//	
//	@Given("^A application is submitted with all mandatory aplication details$")
//	public void setUp() {
//		testBase = new TestBase();
//		serviceUrl = prop.getProperty("URL");
//		apiUrl = prop.getProperty("serviceURL");
//		url = serviceUrl + apiUrl;
//		
//	}
//
//	
//	
//	
//	
//	
//			
//		
//	@Then ("^i will see an error mesage directing me to email submission method$")
//	public void errormessage() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		restClient = new RestClient();
//		HashMap<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Content-Type", "application/xml");
//		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
//		
//		
//		String xmlFilePathString = "/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/misSpelled.xml";
//		Path xmlFilePath = Paths.get(xmlFilePathString);
//		String xml =  new String(Files.readAllBytes(xmlFilePath));
//		
//		CloseableHttpResponse response = restClient.post(url, xml, headerMap);
//
//		int statusCode = response.getStatusLine().getStatusCode();
//		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_500);
//			
//			//2. JsonString:
//		
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		JSONArray jsonArray=responseJson.getJSONArray("errors");
//		for(int i=0; i<jsonArray.length();i++){
//		  JSONObject jso = jsonArray.getJSONObject(i);
//		  System.out.println(jso.getString("title"));
//			Assert.assertEquals(jso.getString("title"), "There was a technical issue submitting the Loan Application online,please use the email submission method and escalate this error to your IT Helpdesk");
//		  
//				}
//		
//		System.out.println("-----------------");
//	
//	}
//	
//	
//	
//	@When("^When field DOB has incorrect value$")
//	public void  enter_invalid_details1()
//	{
//		System.out.print("Userthe user enter invalid DOB ");
//		System.out.print("\n");
//	}
//	
//	
//	
//			
//		
//	@Then ("^i will see an error mesage$")
//	public void errormessage1() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		restClient = new RestClient();
//		HashMap<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Content-Type", "application/xml");
//		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
//		String xmlFilePathString = "/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/misSpelled.xml";
//		Path xmlFilePath = Paths.get(xmlFilePathString);
//		String xml =  new String(Files.readAllBytes(xmlFilePath));
//		
//		CloseableHttpResponse response = restClient.post(url, xml, headerMap);
//
//		int statusCode = response.getStatusLine().getStatusCode();
//		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_500);
//			
//			//2. JsonString:
//		
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		JSONArray jsonArray=responseJson.getJSONArray("errors");
//		for(int i=0; i<jsonArray.length();i++){
//		  JSONObject jso = jsonArray.getJSONObject(i);
//		  System.out.println(jso.getString("title"));
//			Assert.assertEquals(jso.getString("title"), "There was a technical issue submitting the Loan Application online,please use the email submission method and escalate this error to your IT Helpdesk");
//			
//		//  Assert.assertEquals(actual value , expected value);
//			// to assert or verify the values that 
//				}
//		
//		System.out.println("-----------------");
//	
//	}
//	
//	
//	
//	@When("^When field Gender has incorrect value$")
//	public void  enter_invalid_details11()
//	{
//		System.out.print("Userthe user enter invalid Gender ");
//		System.out.print("\n");
//	}
//	
//	@Then ("^Gender value is not correct$")
//	public void errormessage11() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		restClient = new RestClient();
//		HashMap<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Content-Type", "application/xml");
//		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
//		String xmlFilePathString = "/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data//gender_invalid_Response.xml";
//		Path xmlFilePath = Paths.get(xmlFilePathString);
//		String xml =  new String(Files.readAllBytes(xmlFilePath));
//		
//		CloseableHttpResponse response = restClient.post(url, xml, headerMap);
//
//		int statusCode = response.getStatusLine().getStatusCode();
//		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_500);
//			
//			//2. JsonString:
//		
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		JSONArray jsonArray=responseJson.getJSONArray("errors");
//		for(int i=0; i<jsonArray.length();i++){
//		  JSONObject jso = jsonArray.getJSONObject(i);
//		  System.out.println(jso.getString("detail"));
//			Assert.assertEquals(jso.getString("detail"), "Instance validation error: 'Mae' is not a valid value for genderList.");
//		  
//				}
//		
//		System.out.println("-----------------");
//	
//	}
//	
//	@When("^When field application type has incorrect value$")
//	public void  enter_invalid_details111()
//	{
//		System.out.print("Userthe user enter invalid Gender ");
//		System.out.print("\n");
//	}
//	
//	@Then("^application type is not correct$")
//	public void errormessage111() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		restClient = new RestClient();
//		HashMap<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Content-Type", "application/xml");
//		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
//		String xmlFilePathString = "/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data//gender_invalid_Response.xml";
//		Path xmlFilePath = Paths.get(xmlFilePathString);
//		String xml =  new String(Files.readAllBytes(xmlFilePath));
//		
//		CloseableHttpResponse response = restClient.post(url, xml, headerMap);
//
//		int statusCode = response.getStatusLine().getStatusCode();
//		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_500);
//			
//			//2. JsonString:
//		
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		JSONArray jsonArray=responseJson.getJSONArray("errors");
//		for(int i=0; i<jsonArray.length();i++){
//		  JSONObject jso = jsonArray.getJSONObject(i);
//		  System.out.println(jso.getString("detail"));
//			Assert.assertEquals(jso.getString("detail"), "Instance validation error: '' is not a valid value for applicantTypeList.");
//		  
//				}
//		
//		System.out.println("-----------------");
//	
//	}
//	
//
//	@When("^When personname has incorrect$")
//	public void  enter_invalid_details1111()
//	{
//		System.out.print("User missed the perosn first name   ");
//		System.out.print("\n");
//	}
//	
//	@Then("^person name is mandatory should come$")
//	public void errormessage1111() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		restClient = new RestClient();
//		HashMap<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Content-Type", "application/xml");
//		headerMap.put("Ocp-Apim-Subscription-Key", "7531bf090b6b49199ec37f9c818dc417");
//		String xmlFilePathString = "/Users/Agupta/Documents/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data//Person_first_name_missing.xml";
//		Path xmlFilePath = Paths.get(xmlFilePathString);
//		String xml =  new String(Files.readAllBytes(xmlFilePath));
//		
//		CloseableHttpResponse response = restClient.post(url, xml, headerMap);
//
//		int statusCode = response.getStatusLine().getStatusCode();
//		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_409);
//			
//			//2. JsonString:
//		
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		JSONArray jsonArray=responseJson.getJSONArray("errors");
//		for(int i=0; i<jsonArray.length();i++){
//		 JSONObject jso = jsonArray.getJSONObject(i);
//		 System.out.println(jso.getString("title"));
//		 Assert.assertEquals(jso.getString("title"), "First name is a mandatory");
//
//		}
//		}
//		
//			
//		
//				
//			
//			
//		private void assertThat(String string, Object anyOf) {
//			// TODO Auto-generated method stub
//			
//		}
//
//
//
//		private Object anyOf(Object object, Object object2) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//
//		private Object is(String string) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//}
