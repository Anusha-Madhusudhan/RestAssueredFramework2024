/**
 * 
 */
package gitApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
/**
 * 
 */
public class DeleteProductTC09 extends BaseTest {

	@Test
	void validateDeleteProduct() {
		System.out.println(Thread.currentThread().getId());
		Response res=ReusableRequestMethods.deleteRequset("/6",reqSpe);
		
		Assert.assertEquals(res.jsonPath().getInt("id"), 6);
		
		assertThat(res.jsonPath().get("title"),notNullValue());
		assertThat(res.jsonPath().get("price"),is(instanceOf(Integer.class)));
		assertThat(res.jsonPath().get("description"),notNullValue());
		assertThat(res.jsonPath().get("category"),notNullValue());
		assertThat(res.jsonPath().get("image"),notNullValue());
		assertThat(res.jsonPath().get("rating"),aMapWithSize(equalTo(2)));
		
		System.out.println(res.body().asPrettyString());
	}
	
}
