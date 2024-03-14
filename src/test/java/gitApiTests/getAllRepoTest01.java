/**
 * 
 */
package gitApiTests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requsetMethods.ReusableRequestMethods;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 */
public class GetAllRepoTest01 extends BaseTest {
	
	

//	@Test
	 void validateGetAllRepo() throws JsonMappingException, JsonProcessingException {
		
		
		

		Response res = RestAssured.given().header("token", bearerToken).header("Content-Type", ContentType.JSON).when()
				.get("/users/Anusha-Madhusudhan/repos");

//		System.out.println(res.then().log().all());

//		System.out.println(res.then().log().status());
		
		
		
		
//		 USING JAYWAY LIBRARIES:
//		---------------------------
//
//		List<String> repoNames = JsonPath.read(res.asString(), "$..name");
//
//		for(String repoName:repoNames) {
//			System.out.println(repoName);
//		}
		
		
		// USING JACKSON LIBRARIE--------------------
//		-------------------------------------------------
		
//		JsonNode node=new ObjectMapper().readTree(res.asString());
//		
//		System.out.println(node.getNodeType());
//		
//		System.out.println(node.get(0));
//		
//		node.forEach(k->System.out.println(k));
//		
//		System.out.println(node.get(0).get("owner").get("login"));
		
		
	
		
		
//		 USING REST ASSURED JSONPATH TO CONVERT JSON OBJECT TO MAP---------------------
//		-------------------------------------------------------------
		
		Map<String, Object> jsonResOb=res.jsonPath().getMap("[0]");
		
//		jsonResOb.keySet().forEach(k->System.out.println(k));
		
		jsonResOb.entrySet().forEach(k->System.out.println(k.getKey()+"  "+k.getValue()));
		
		
		res.then().assertThat().statusCode(200);
		
		

	}
	
	
	@Test
	 void validateGetAllRepoFromGit() {
		
		Response res=ReusableRequestMethods.getRequest("/users/Anusha-Madhusudhan/repos", reqSpe);
		
		res.then().assertThat().statusCode(200);
		
		List<Object> resObj=res.jsonPath().getList("");
		
		assertThat(resObj.size(),equalTo(15));
		
		assertThat(JsonPath.read(res.asPrettyString(), "$[?(@.full_name=='Anusha-Madhusudhan/JavaBasics')].id"),notNullValue());
		
//		assertThat("For Report", false);
		
	}

}
