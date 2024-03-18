/**
 * 
 */
package pojos;

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
public class CartProducts {
	
	private int productId;
	private int quantity;

}
