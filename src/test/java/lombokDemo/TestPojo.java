/**
 * 
 */
package lombokDemo;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import lombok.EqualsAndHashCode;

/**
 * 
 */
public class TestPojo {

	@Test
	public void validatePojo() {
		
//		DummyPOJO dp=DummyPOJO.builder().id(1).name("aaa").email("ass").phoneNum("12345").build();
//		DummyPOJO dp=new DummyPOJO();
		
		
		DummyPOJO dp=DummyPOJO.builder().id(1).email("ass").phoneNum("12345").build(); 
		// name will be default value what we have set in pojo class
		
		System.out.println(dp.getId()+" "+dp.getName()+" "+dp.getPhoneNum()+" "+dp.getEmail());
		
		
		
		DummyPOJO dp2=DummyPOJO.builder().id(1).name("Anusha").email("ass").phoneNum("12345").build();
		
		System.out.println(dp2.getId()+" "+dp2.getName()+" "+dp2.getPhoneNum()+" "+dp2.getEmail());
		
		
		Set<DummyPOJO> hs=new HashSet<DummyPOJO>();
		hs.add(dp2);
		hs.add(dp);
		
		System.out.println(hs); 
		// we have added the annotation @Data which has @EqualsAndHashCode 
//		no need to override hashcode and equals
		// to compare 2 objects
		
		
		
		Assert.assertEquals(dp, dp2);
		
	}

	
}
