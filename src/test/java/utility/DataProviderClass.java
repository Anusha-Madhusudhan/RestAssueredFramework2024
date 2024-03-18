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

import contants.FileConstatnt;
import pojos.ProductPOJO;

/**
 * 
 */
public class DataProviderClass {
	
	
	@DataProvider(name = "ProductTestData",parallel = true)
	public Iterator<Map<String, Object>> readdata(){
		
		
		List<Map<String, Object>> testData=ExcelUtil.getTestDataFromExcel(FileConstatnt.productTestDataPath,"productTestData");
		
		System.out.println(testData);
		
		return testData.iterator();
		
	}
	
	
	@DataProvider(name = "ProductTestDataFromPoiji")
	public Iterator<ProductPOJO> readProductdata(){
		
		List<ProductPOJO> productList=Poiji.fromExcel(new File(FileConstatnt.productTestDataPath), ProductPOJO.class);
		
//		System.out.println(productList);
		
		return productList.iterator();
		
	}
	

}
