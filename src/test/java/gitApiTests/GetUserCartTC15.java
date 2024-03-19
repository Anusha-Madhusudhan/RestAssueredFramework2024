/**
 * 
 */
package gitApiTests;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import contants.FileConstatnt;
import io.restassured.response.Response;
import pojos.Cart;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
/**
 * 
 */
public class GetUserCartTC15 extends BaseTest{
	
	@Test
	void validateGetUserCart() throws JsonMappingException, JsonProcessingException {
		Response res=ReusableRequestMethods.getRequest("/user/2", reqSpe);
		
		List<Cart> cartList=res.jsonPath().getList("");
		System.out.println(cartList);
		
		List<Integer> userIdList=res.jsonPath().getList("userId");
		
		JsonNode jn=new ObjectMapper().readTree(res.body().asString());
		
		String cartObj=jn.get(0).toPrettyString();
		
		assertThat(cartObj,matchesJsonSchema(new File(FileConstatnt.cartSchemaPath)));
		
		for(int userId:userIdList) {
			assertThat(userId,equalTo(2));
		}
	}

}
