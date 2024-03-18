/**
 * 
 */
package gitApiTests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojos.ProductPOJO;
import requsetMethods.ReusableRequestMethods;
import utility.DataProviderClass;


/**
 * 
 */
public class AddProductTest03 extends BaseTest{
	
	@Test(dataProvider = "ProductTestData",dataProviderClass =DataProviderClass.class )
	 void validateAddProduct(Map<String, Object> productMapData) {
		System.out.println(Thread.currentThread().getId());
		Response res=ReusableRequestMethods.postRequest(productMapData, "", reqSpe);
		
		System.out.println(res.body().asPrettyString());
	}
	
	
	@Test(dataProvider = "ProductTestDataFromPoiji",dataProviderClass =DataProviderClass.class )
	 void validateAddProduct2(ProductPOJO productMapData) {
		
		System.out.println(Thread.currentThread().getId());
		
		String newTitle=productMapData.getTitleStr()+RandomStringUtils.randomAlphabetic(3);
		
		productMapData.setTitle(newTitle);
		
		System.out.println(productMapData);
		
		Response res=ReusableRequestMethods.postRequest(productMapData, "", reqSpe);
		
		System.out.println(res.body().asPrettyString());
	}

}
