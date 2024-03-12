/**
 * 
 */
package requsetMethods;

import java.io.File;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



/**
 * 
 */
public class ReusableRequestMethods {
	
	
	public static void postRequest(Map<String, Object> mapPayload, String endPoint,Map<String, String> mapHeader) {
		
	}

	
     public static void postRequest(String strPayload, String endPoint,Map<String, String> mapHeader) {
		
	}
     
     public static void postRequest(File filePayload, String endPoint,Map<String, String> mapHeader) {
 		
 	}
     
     
     public static void postRequest(Object pojoPayload, String endPoint,Map<String, String> mapHeader) {
  		
  	}
     
     
     public static void postRequest(Object pojoPayload, String endPoint,Headers headers) {
   		
   	}
     
     public static Response getRequest(String endPoint,RequestSpecification reqSpec) {
    		
    	 return RestAssured.given().spec(reqSpec).get(endPoint);
    	}
}
