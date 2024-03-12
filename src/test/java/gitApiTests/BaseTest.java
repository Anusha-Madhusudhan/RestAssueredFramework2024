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
import utility.JsonUtility;

/**
 * 
 */
public class BaseTest {
	
	public static final String bearerToken="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";
	public static RequestSpecification reqSpe;
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		Map<String, String> apiMap=JsonUtility.getJsondataAsMap(FileConstatnt.apiFile);
		String api=System.getProperty("api");
		System.out.println("*****************"+System.getProperty("api"));
		switch (api) {
		case "gitAPI":
			RestAssured.baseURI=apiMap.get("gitAPI");
			break;
		case "products":
			RestAssured.baseURI=apiMap.get("products");
			break;
		case "cart":
			RestAssured.baseURI=apiMap.get("cart");
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
		
		reqSpe=new RequestSpecBuilder().addHeader("token", bearerToken)
				                    .addHeader("Content-Type", "application/json").build();
		
	}

}
