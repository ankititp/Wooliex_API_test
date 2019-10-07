package com.qa.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	//1. GET Method without Headers:
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
	//CloseableHttpClient httpClient = HttpClients.createDefault();
	CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(createSSLContext()).build();
	HttpGet httpget = new HttpGet(url); //http get request
	CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		return closebaleHttpResponse;
		
	}
	
	//2. GET Method with Headers:
		public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		//CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(createSSLContext()).build();
		HttpGet httpget = new HttpGet(url); //http get request
		
		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		return closebaleHttpResponse;
			
		}
	
	//3. POST Method:
		public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
			//CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(createSSLContext()).build();
			HttpPost httppost = new HttpPost(url); //http post request
			
			httppost.setEntity(new StringEntity(entityString)); //for payload
			
			//for headers:
			
			for(Map.Entry<String,String> entry : headerMap.entrySet())
			{
				httppost.addHeader(entry.getKey(), entry.getValue());
			}
			
			
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost);
			return closebaleHttpResponse;
			
			
		}
		
		private SSLContext createSSLContext(){
			String keyPassphrase = "P?>s*5aW";

			KeyStore keyStore;
			try {
				keyStore = KeyStore.getInstance("PKCS12");
				keyStore.load(new FileInputStream("src\\main\\java\\com\\qa\\client\\MyCRMAPIM-nonProd.pfx"), keyPassphrase.toCharArray());
				SSLContext sslContext = SSLContexts.custom()
				        .loadKeyMaterial(keyStore, keyPassphrase.toCharArray())
				        .build();
				return sslContext;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
	
		
	
	
	

}
