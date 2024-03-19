/**
 * 
 */
package poijiLibraryDemo;

import com.poiji.annotation.ExcelCellName;
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
@ExcelSheet("Products")
public class CartProductsPoiji {
	@ExcelCellName("productId")
	private int productId;
	@ExcelCellName("quantity")
	private int quantity;

}
