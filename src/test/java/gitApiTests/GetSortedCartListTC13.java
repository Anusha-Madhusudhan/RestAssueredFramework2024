/**
 * 
 */
package gitApiTests;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;

/**
 * 
 */
public class GetSortedCartListTC13 extends BaseTest{
	
	@Test
	void validateGetSortedCartList() {
		
		reqSpe.queryParams("sort", "desc");
		
		Response res=ReusableRequestMethods.getRequest("", reqSpe);
		
		List<Integer> cartIdList=res.jsonPath().getList("id");
		
		List<Integer> actualIdList=cartIdList;
		
		Collections.sort(cartIdList, Comparator.reverseOrder());
		
		Assert.assertEquals(actualIdList, cartIdList);
		
		System.out.println(cartIdList);
		
	}

}
