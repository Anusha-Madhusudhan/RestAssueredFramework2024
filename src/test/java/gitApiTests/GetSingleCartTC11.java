/**
 * 
 */
package gitApiTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojos.Cart;
import pojos.CartProducts;
import requsetMethods.ReusableRequestMethods;

/**
 * {
    "id": 5,
    "userId": 3,
    "date": "2020-03-01T00:00:00.000Z",
    "products": [
      {
        "productId": 7,
        "quantity": 1
      },
      {
        "productId": 8,
        "quantity": 1
      }
    ],
    "__v": 0
  }
 */
public class GetSingleCartTC11 extends BaseTest{

	@Test
	void validateGetSingleCart() {
		Response res=ReusableRequestMethods.getRequest("/5", reqSpe);
		
		CartProducts pro1=CartProducts.builder().productId(7).quantity(1).build();
		CartProducts pro2=CartProducts.builder().productId(8).quantity(1).build();
		
		
		List<CartProducts> proListPayload=new ArrayList<CartProducts>(Arrays.asList(pro1,pro2));
		
		Cart payload=Cart.builder().userId(3).date("2020-03-01T00:00:00.000Z").products(proListPayload).build();
		
		Cart cart=res.jsonPath().getObject("", Cart.class);
		
		System.out.println(cart.getUserId()+" "+cart.getDate());
		
		List<CartProducts> proList=cart.getProducts();
		
		
		Assert.assertEquals(cart, payload);
		Assert.assertEquals(res.jsonPath().getInt("id"), 5);
		
		
		
		System.out.println(proList);
	}
}
