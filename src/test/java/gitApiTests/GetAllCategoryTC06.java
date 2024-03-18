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
public class GetAllCategoryTC06 extends BaseTest{
	
	@Test
	void validateGetAllCategory() {
		System.out.println(Thread.currentThread().getId());
		Response res=ReusableRequestMethods.getRequest("/categories", reqSpe);
		
		System.out.println(res.body().asPrettyString());
		
		assertThat(res.jsonPath().get("[0]"), equalTo("electronics"));
		assertThat(res.jsonPath().get("[1]"), equalTo("jewelery"));
		assertThat(res.jsonPath().get("[2]"), equalTo("men's clothing"));
		assertThat(res.jsonPath().get("[3]"), equalTo("women's clothing"));
		
		assertThat(res.jsonPath().getList("").size(),equalTo(4));
		
	}

}
