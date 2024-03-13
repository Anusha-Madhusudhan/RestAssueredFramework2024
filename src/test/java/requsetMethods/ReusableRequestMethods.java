/**
 * 
 */
package requsetMethods;

import java.io.File;
import java.util.Map;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reports.ExtentReportListeners;



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
    	 Response res= RestAssured.given().spec(reqSpec).get(endPoint);
    	 
    	 // Logging Request and response
    	 
    	 QueryableRequestSpecification qReqSpe=SpecificationQuerier.query(reqSpec);
    	 
    	 
    	 ExtentReportListeners.extentTest.get().info("Base URI :: "+qReqSpe.getBaseUri());
    	 ExtentReportListeners.extentTest.get().info("End Point :: "+endPoint);
    	 ExtentReportListeners.extentTest.get().info("Http method :: "+"Get");
    	 ExtentReportListeners.extentTest.get().info("Request Headers :: "+qReqSpe.getHeaders().asList().toString());
    	 
    	 ExtentReportListeners.extentTest.get().info("Response status code :: "+res.statusCode());
    	 ExtentReportListeners.extentTest.get().info("Response header :: ");
    	 
    	 String[][] headerArray= res.getHeaders().asList().stream().map(header -> new String[] {header.getName(),header.getValue()})
    	               .toArray(String[][] ::new);
    	 
    	
    	 ExtentReportListeners.extentTest.get().info(MarkupHelper.createTable(headerArray));
    	 ExtentReportListeners.extentTest.get().info("Response Body is :: ");
    	 ExtentReportListeners.extentTest.get().info(MarkupHelper.createCodeBlock(res.body().asString(), CodeLanguage.JSON));
    	 return res;
    	}
}
