/**
 * 
 */
package poijiLibraryDemo;

import java.io.File;
import java.util.Arrays;
import java.util.List;


import org.testng.annotations.Test;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

import contants.FileConstatnt;



/**
 * 
 */
public class PoijiTest {
	
	@Test
	public void poijiTest() {
//	List<Product> productList=Poiji.fromExcel(new File("C:\\Users\\anush\\RestAssured_APITesting2024\\GitApiTesting\\src\\test\\resources\\testData\\productTestData.xlsx"), Product.class);
//	
//	System.out.println(productList);
		
		List<CartProductsPoiji> productList=Poiji.fromExcel(new File(FileConstatnt.CartTestDataPath), CartProductsPoiji.class);
	
		System.out.println(productList);
		
		
		List<CartPoiji> cartList=Poiji.fromExcel(new File(FileConstatnt.CartTestDataPath), CartPoiji.class);
		
		for(CartPoiji cp:cartList) {
			List<String> proIdList=cp.getProductIdList();
			List<CartProductsPoiji> cartProList=cp.getProducts();;
			for(CartProductsPoiji cpp:productList) {
				if(proIdList.contains(String.valueOf(cpp.getProductId()))) {
					cartProList.add(cpp);
				}
			}
		}
		
		
	
		System.out.println(cartList);
		
	}

}
