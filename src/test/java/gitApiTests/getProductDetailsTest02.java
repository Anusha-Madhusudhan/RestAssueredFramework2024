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
public class GetProductDetailsTest02 extends BaseTest{
	
	@Test
	void validateGetProductDetails() {
		
		System.out.println(Thread.currentThread().getId());
		
		Response res=ReusableRequestMethods.getRequest("/21", reqSpe);
		
		assertThat(res.statusCode(), equalTo(200));
		
		
		
	}

}
