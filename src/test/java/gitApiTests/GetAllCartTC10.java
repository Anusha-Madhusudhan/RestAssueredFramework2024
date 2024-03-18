/**
 * 
 */
package gitApiTests;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;
import utility.JsonUtility;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 */
public class GetAllCartTC10 extends BaseTest {

	@Test
	void vaidateGetAllCart() throws JsonMappingException, JsonProcessingException {

		String schemaFile = System.getProperty("user.dir") + "\\src\\test\\resources\\schema\\cartObject.json";

		Response res = ReusableRequestMethods.getRequest("", reqSpe);

		Map<String, Object> resMap = JsonUtility.getJsondataAsMap(res.body().asString(), "[0]");

		for (Map.Entry<String, Object> entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}

		JsonNode jn = new ObjectMapper().readTree(res.body().asString());

		System.out.println(jn.get(0));
		
		System.out.println(jn.getNodeType()); // Array
		
		System.out.println(jn.get(0).toPrettyString());
		
		assertThat(jn.get(0).toPrettyString(),matchesJsonSchema(new File(schemaFile)));
		// validating schema for one jsonObject

		System.out.println(res.body().asPrettyString());

	}

}
