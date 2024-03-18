/**
 * 
 */
package gitApiTests;


import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeSuite;

import contants.FileConstatnt;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import reports.ExtentReportListeners;
import utility.JsonUtility;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 */
public class BaseTest {
	
	public static final String bearerToken="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";
	public static RequestSpecification reqSpe;
	
	
	@BeforeSuite
	 void setUp() throws IOException {
		
		Map<String, String> apiMap=JsonUtility.getJsondataAsMap(FileConstatnt.apiFile);
		String api=System.getProperty("api"); // mvn test -Dapi=gitAPI  passing value form command line
		System.out.println("*****************"+System.getProperty("api"));
		switch (api) {
		case "gitAPI":
			RestAssured.baseURI=apiMap.get("gitAPI");
			reqSpe=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI)
                    .addHeader("token", bearerToken)
                    .addHeader("Content-Type", "application/json").build();
			break;
		case "products":
			RestAssured.baseURI=apiMap.get("products");
			reqSpe=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI)
                    .addHeader("Content-Type", "application/json").build();
			break;
		case "cart":
			RestAssured.baseURI=apiMap.get("cart");
			reqSpe=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI)
                    .addHeader("Content-Type", "application/json").build();
			break;
		case "user":
			RestAssured.baseURI=apiMap.get("user");
			break;	
		case "login":
			RestAssured.baseURI=apiMap.get("login");
			break;
		default:
			System.out.println("Wrong Input");
			break;
		}
		
		
		
	}

}
