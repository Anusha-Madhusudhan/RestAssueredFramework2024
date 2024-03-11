/**
 * 
 */
package mockServer;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.MediaType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


/**
 * 
 */
public class MockServerImpln {
	
	
	static ClientAndServer mockServer;
	
	@BeforeMethod
	void setUp() {
		mockServer=startClientAndServer(9009);
		
	}
	
	
	@Test
	void test() {
		new MockServerClient("localhost", 9009)
	    .when(
	        request()
	            .withMethod("POST")
	            .withPath("/login")
	            .withBody("{username: 'foo', password: 'bar'}")
	    )
	    .respond(
	        response()
	            .withStatusCode(302)
	            .withCookie(
	                "sessionId", "2By8LOhBmaW5nZXJwcmludCIlMDAzMW"
	            )
	            .withHeader(
	                "Location", "https://www.mock-server.com"
	            )
	    );
		RestAssured.baseURI="http://localhost:9009";
		
		RestAssured
				.given()
				.body("{username: 'foo', password: 'bar'}")
				.when()
				.post("/login")
				.then()
				.log()
				.all();
		
//		System.out.println(res.getHeader("Location"));
		
	}
	
	
	@Test
	void test2() {
//		File f=new File("C:\\Users\\anush\\RestAssured_APITesting2024\\GitApiTesting\\src\\test\\resources\\user.json");
		new MockServerClient("localhost", 9009)
	    .when(
	        request()
	            .withMethod("GET")
	            .withPath("/user")
	            
	    )
	    .respond(
	        response()
	            .withStatusCode(200)
	            .withBody("{\"menu\": {\r\n"
	            		+ "  \"id\": \"file\",\r\n"
	            		+ "  \"value\": \"File\",\r\n"
	            		+ "  \"popup\": {\r\n"
	            		+ "    \"menuitem\": [\r\n"
	            		+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
	            		+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
	            		+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
	            		+ "    ]\r\n"
	            		+ "  }\r\n"
	            		+ "}}")
	            .withContentType(MediaType.APPLICATION_JSON)
	            
	            
	            
	    );
		RestAssured.baseURI="http://localhost:9009";
		
		RestAssured
				.when()
				.get("/user")
				.then()
				.log()
				.all();
		
//		System.out.println(res.getHeader("Location"));
		
	}
	
	
	@AfterMethod
	void tearDown() {
		mockServer.stop();
	}

}
