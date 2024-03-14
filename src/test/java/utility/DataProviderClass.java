/**
 * 
 */
package utility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.poiji.bind.Poiji;

import pojos.ProductPOJO;

/**
 * 
 */
public class DataProviderClass {
	public static final String productTestDataPath="C:\\Users\\anush\\RestAssured_APITesting2024\\GitApiTesting\\src\\test\\resources\\testData\\productTestData.xlsx";
	
	@DataProvider(name = "ProductTestData")
	public Iterator<Map<String, Object>> readdata(){
		
		
		List<Map<String, Object>> testData=ExcelUtil.getTestDataFromExcel(productTestDataPath,"productTestData");
		
		System.out.println(testData);
		
		return testData.iterator();
		
	}
	
	
	@DataProvider(name = "ProductTestDataFromPoiji",parallel = true)
	public Iterator<ProductPOJO> readProductdata(){
		
		List<ProductPOJO> productList=Poiji.fromExcel(new File(productTestDataPath), ProductPOJO.class);
		
//		System.out.println(productList);
		
		return productList.iterator();
		
	}
	

}
