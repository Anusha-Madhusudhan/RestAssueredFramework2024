/**
 * 
 */
package pojos;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 
 */
@ToString
@Data
@Builder
public class ProductPOJO {
	
	@JsonIgnore
	@ExcelCellName("title")
	private String titleStr;
	
	
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
