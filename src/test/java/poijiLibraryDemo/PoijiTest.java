/**
 * 
 */
package poijiLibraryDemo;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import com.poiji.bind.Poiji;



/**
 * 
 */
public class PoijiTest {
	
	@Test
	public void poijiTest() {
	List<Product> productList=Poiji.fromExcel(new File("C:\\Users\\anush\\RestAssured_APITesting2024\\GitApiTesting\\src\\test\\resources\\testData\\productTestData.xlsx"), Product.class);
	
	System.out.println(productList);
	
	}

}
