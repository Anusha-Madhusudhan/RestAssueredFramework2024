/**
 * 
 */
package gitApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojos.ProductPOJO2;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
/**
 * 
 */
public class UpdateProductTC08 extends BaseTest{
	
	@Test
	void validateUpdateProductTC() {
		System.out.println(Thread.currentThread().getId());
		ProductPOJO2 payload=ProductPOJO2.builder()
				.title("New Titel").price(100).description("New Desc").image("New Image").category("New Category").build();
		
		reqSpe.body(payload);
		
		Response res=ReusableRequestMethods.putRequest("/7",reqSpe);
		
		System.out.println(res.body().asPrettyString());
		
		assertThat(String.valueOf(res.jsonPath().getInt("id")),equalTo("7"));		
		
		ProductPOJO2 resObject=res.body().as(ProductPOJO2.class);
		
		Assert.assertEquals(payload,resObject);
		
		System.out.println(payload+" "+resObject);
	
		
	}

}
