/**
 * 
 */
package gitApiTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;

/**
 * 
 */
public class Get5ProductsTest04 extends BaseTest {
	
	@Test
	void validateGet5Products() {
		System.out.println(Thread.currentThread().getId());
		reqSpe.queryParam("limit", 5);
		
		Response res=ReusableRequestMethods.getRequest("", reqSpe);
		
		List<Object> proList=res.jsonPath().getList("");
		
		Assert.assertEquals(5, proList.size());
		
		System.out.println(res.body().asPrettyString());
		
	}

}
