/**
 * 
 */
package gitApiTests;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

/**
 * 
 */
public class GetInCategoryTC07 extends BaseTest {

	@Test
	void validateGetInCategoryTC07() {
		System.out.println(Thread.currentThread().getId());
		Response res=ReusableRequestMethods.getRequest("/category/jewelery", reqSpe);
		
	   List<String> items=JsonPath.read(res.body().asString(), "$..category");
	
	    for(String s:items) {
	    	
	    	assertThat(s,equalTo("jewelery"));
		
	     }
	    
	    
	   
		
		System.out.println(res.body().asPrettyString());
	}

	

}
