/**
 * 
 */
package poijiLibraryDemo;

import java.util.Map;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;

import lombok.ToString;

/**
 * 
 */
@ToString
public class Product {
	
	@ExcelCellName("title")
    private	String title;
	@ExcelCellName("price")
	private	int price;
	@ExcelCellName("description")
	private	String description;
	@ExcelCellName("image")
	private	String image;
	@ExcelCellName("category")
	private	String category;
	
	
	@ExcelUnknownCells
	private Map<String, String> extraCellInExcelSheet;
	
	
}
