/**
 * 
 */
package pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *    {
                    email:'John@gmail.com',
                    username:'johnd',
                    password:'m38rmF$',
                    name:{
                        firstname:'John',
                        lastname:'Doe'
                    },
                    address:{
                        city:'kilcoole',
                        street:'7835 new road',
                        number:3,
                        zipcode:'12926-3874',
                        geolocation:{
                            lat:'-37.3159',
                            long:'81.1496'
                        }
                    },
                    phone:'1-570-236-7033'
                }
 */
@Data // provides getter setter hashcode equals method
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true) // to build the pojo object
@EqualsAndHashCode // no need to override hashcode equals method while compairing the obects of the class
@JsonIgnoreProperties(ignoreUnknown = true) // to ignore the unknown fields of response while comparing with the pojo object
public class User {
	
//	List<String> genderList=new ArrayList<String>(Arrays.asList("male","female","others"));
	
//	String gender=genderList.stream().findAny().get();
	
	
	String gender=Stream.of("male","female","others").findAny().get();  // default values
	

	String email="abc@gmail.com"; // // default values
	String username;
	String password;
	Name name;
	Address address;
	String phone;
	
}
