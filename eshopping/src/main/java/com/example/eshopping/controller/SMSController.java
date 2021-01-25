package com.example.eshopping.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.model.address.SmsResponse;
import com.example.eshopping.util.JSONUtil;

@RestController
@RequestMapping("/sms")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SMSController {

	
	@GetMapping("/sendSms")
	public BaseResponse sendSMS() {
		BaseResponse response = new BaseResponse();
		try {
			String uri = 
					"https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey=Yt7gu65VeEKdMBL9gjsjjA&senderid=SMSTST&channel=2&DCS=0&flashsms=0&number=919344159742&text=test message&route=1";
			String mainUrl="https://www.smsgatewayhub.com/api/mt/SendSMS?";
			String apikey = "Yt7gu65VeEKdMBL9gjsjjA";
			//Approved sender id(6 characters string only).
			String senderId = "SMSTST";
			//Message channel Promotional=1 or Transactional=2.
			String channel = "2";
			//Default is 0 for normal message, Set 8 for unicode sms.
			String DCS = "0";
			 //Default is 0 for normal sms, Set 1 for immediate display.
			 String flashsms = "0";
			//Your message to send.
			String message = "Check message";
			//Recipient mobile nCheckumber (pass with comma seprated if need to send on more then one number)
			String number = "919500544899";
			//define route
			String route="1";
			//Prepare parameter string 
			String APIKey = "Yt7gu65VeEKdMBL9gjsjjA";
			//Multiple mobiles numbers separated by comma
			//Sender ID should be 6 characters long.
			String senderid= "SMSTST";
			//Your message to send, Add URL encoding here.
			String text = "Test message";
			//Prepare Url
			URLConnection myURLConnection=null;
			URL myURL=null;
			BufferedReader reader=null;
			//encoding message
			String encoded_message=URLEncoder.encode(message);
			//Send SMS API
			//Prepare parameter string
			StringBuilder sbPostData= new StringBuilder("https://www.smsgatewayhub.com/api/mt/SendSMS?");
			sbPostData.append("APIKey="+ APIKey);
			sbPostData.append("&number="+number);
			sbPostData.append("&text="+encoded_message);
			sbPostData.append("&route="+route);
			sbPostData.append("&channel="+channel);
			sbPostData.append("&flashsms="+flashsms);
			sbPostData.append("&DCS="+DCS);
			//final string
			mainUrl = sbPostData.toString();
			try
			{
			 //prepare connection
			 myURL = new URL(mainUrl);
			 myURLConnection = myURL.openConnection();
			 myURLConnection.connect();
			 reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			 //reading response
			 String response1;
			 while ((response1 = reader.readLine()) != null)
			 //print response
			 System.out.println(response1);

			 //finally close connection
			 reader.close();
			    
			} 
			catch (IOException e) 
			{ 
			  e.printStackTrace();
			} 
//				 RestTemplate restTemplate = new RestTemplate();
//				    SmsResponse result = restTemplate.getForObject(uri, SmsResponse.class);
////				 restTemplate.execute(uri);
			   System.out.println();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return response;
	}
	
	@GetMapping("/validatePinCode/{pincode}")
	public BaseResponse validatePinCode(@PathVariable String pincode) {
		BaseResponse response = new BaseResponse();
		try {
			  RestTemplate restTemplate = new RestTemplate();
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.set("Content-Type", "application/json");
			  httpHeaders.set("Authorization", "Token a3e76b4efa800da090c3aa95d8dec8a6717ccf9c");
			  HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
			  String url="https://staging-express.delhivery.com/c/api/pin-codes/json/?filter_codes="+pincode;
			  ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			  System.out.println("result "+result.getBody().toString());
			  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return response;
	}
}
