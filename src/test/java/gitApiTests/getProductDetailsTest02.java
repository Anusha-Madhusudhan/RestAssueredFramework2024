/**
 * 
 */
package gitApiTests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
/**
 * 
 */
public class getProductDetailsTest02 extends BaseTest{
	
	@Test
	void validateGetProductDetails() {
		
		Response res=ReusableRequestMethods.getRequest("/1", reqSpe);
		
		assertThat(res.statusCode(), equalTo(200));
		
		
		
	}

}
