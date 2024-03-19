/**
 * 
 */
package gitApiTests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import poijiLibraryDemo.CartPoiji;
import requsetMethods.ReusableRequestMethods;
import utility.DataProviderClass;

/**
 * 
 */
public class AddNewCartTC16 extends BaseTest{
	
	@Test(dataProvider = "CartTestDataFromPoiji",dataProviderClass = DataProviderClass.class)
	void validateAddNewCart(CartPoiji cart) {
		
		System.out.println(cart);
			Response res=ReusableRequestMethods.postRequest(cart, "", reqSpe);
			System.out.println(res.body().asPrettyString());
		
		
		
	}

}
