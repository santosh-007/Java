package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

	public static void main(String[] args) {
		
		

	}
	
	
	
	String getResult(String mobileNumber, String smsText, String to ,String Time, String Circle, String Operator){
		  StringBuffer outputResult=new StringBuffer();
		  String output;

		  
		   	  try {
		   		    String httpURL="https://mycard2uat.rblbank.com/nginx/ThirdParty/MW/API";
		   		    
//		   		 if(httpURL.startsWith("https")){
//		             moservice.OlaSSLUtilities.trustAllHostnames() ;
//		             moservice.OlaSSLUtilities.trustAllHttpsCertificates() ;
//		         }
		   		    
			   		URL url = new URL(httpURL);
			   		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			   		conn.setConnectTimeout(5000);
			   		conn.setReadTimeout(5000);
			   		conn.setDoOutput(true);
			   		conn.setRequestMethod("POST");
			   		conn.setRequestProperty("Content-Type", "application/json");
	 				String input = "{\"RequestHeader\":{\"AdditionalInfo\":{\"JourneyId\":\"\",\"LanguageId\":\"1\",\"SVersion\":\"3.0\",\"SessionId\":\"\"},\"DeviceInfo\":{\"AppVersion\":\"\",\"DeviceFamily\":\"\",\"DeviceFormat\":\"\",\"DeviceID\":\"\",\"DeviceIMEI\":\"\",\"DeviceIp\":\"\",\"DeviceName\":\"\",\"DeviceOS\":\"\",\"DeviceType\":\"\",\"DeviceVersion\":\"\"},\"MessageKey\":{\"ChannelId\":\"MYC_POST\",\"RequestUUID\":\"1615790302864\",\"ServiceRequestId\":\"savePennyDropShortCodeDetails\",\"ServiceRequestVersion\":\"1.0\"},\"RequestMessageInfo\":{\"BankId\":\"\",\"MessageDateTime\":\"\",\"TimeZone\":\"\"},\"Security\":{\"Token\":{\"Certificate\":\"\",\"MessageHashKey\":\"\",\"MessageIndex\":\"\",\"PasswordToken\":{\"Password\":\"\",\"UserId\":\"\"}}}},\"RequestBody\":{\"savePennyDropShortCodeDetailsRequestBody\":{\"mobile\":\""+mobileNumber+"\",\"SMSText\":\""+smsText+"\",\"Time\":\""+Time+"\",\"recipient\":\""+to+"\",\"Circle\":\""+Circle+"\",\"Operator\":\""+Operator+"\"}}}";
//					logger.info("[rbl.jsp] input parameter:"+input);
			   		OutputStream os = conn.getOutputStream();
			   		os.write(input.getBytes());
			   		os.flush();
	              
//			   		logger.info("[rbl.jsp] ResponseCode:"+conn.getResponseCode()+" mobileNumber :"+mobileNumber);
			   		
			   		BufferedReader br = new BufferedReader(new InputStreamReader(
			   				(conn.getInputStream())));

			   		while ((output = br.readLine()) != null) {
						outputResult=outputResult.append(output);
					}
			   		conn.disconnect();

			   	  } catch (MalformedURLException e) {
//			   		logger.error("[rbl.jsp] Exception : "+e+" mobileNumber :"+mobileNumber);
			   		e.printStackTrace();

			   	  } catch (IOException e) {
//			   		logger.error("[rbl.jsp] Exception is : "+e+" mobileNumber :"+mobileNumber);
			   		e.printStackTrace();

			   	 }
				return outputResult.toString();
	}


}
