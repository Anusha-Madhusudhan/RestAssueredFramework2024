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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DummyPOJO {
	
  private  int id;
  @Builder.Default private String name="Anusha";
//  private String name="Anusha";
  private  String email;
  private String phoneNum;

}



