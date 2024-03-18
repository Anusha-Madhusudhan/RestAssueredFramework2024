/**
 * 
 */
package gitApiTests;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;

/**
 * 
 */
public class GetSortedProdectListTC05 extends BaseTest {

	@Test
	void validateGetSortedProdectList() {
		System.out.println(Thread.currentThread().getId());
		
		reqSpe.queryParam("sort", "desc");
		
		Response res=ReusableRequestMethods.getRequest("", reqSpe);
		
		List<Integer> proIdList=JsonPath.read(res.body().asString(), "$..id");
		
		List<Integer> actualProIdList=proIdList;
		
		Collections.sort(actualProIdList, Comparator.reverseOrder());
		
		Assert.assertEquals(actualProIdList, proIdList);
		
//		System.out.println(res.body().asPrettyString());
		
	}
	
}
