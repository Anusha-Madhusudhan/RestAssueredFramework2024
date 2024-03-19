/**
 * 
 */
package poijiLibraryDemo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelCellRange;
import com.poiji.annotation.ExcelSheet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ExcelSheet("Cart")
public class CartPoiji {

	@ExcelCellName("userId")
	private int userId;
	@ExcelCellName("date")
	private String date;
	
	
	@ExcelCellName("products")
	@JsonIgnore
	private List<String> productIdList;
	
	private List<CartProductsPoiji> products=new ArrayList<CartProductsPoiji>();
	
}
