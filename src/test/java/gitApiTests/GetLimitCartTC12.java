/**
 * 
 */
package gitApiTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojos.Cart;
import requsetMethods.ReusableRequestMethods;

/**
 * 
 */
public class GetLimitCartTC12 extends BaseTest{

	@Test
	void validateGetLimitCart() {
		
		reqSpe.queryParams("limit", "5");
		
		Response res=ReusableRequestMethods.getRequest("", reqSpe);
		
		List<Cart> cartList=res.jsonPath().getList("");
		
		Assert.assertEquals(cartList.size(), 5);
		
	}
	

}
