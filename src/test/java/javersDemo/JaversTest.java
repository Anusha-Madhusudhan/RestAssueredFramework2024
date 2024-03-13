/**
 * 
 */
package javersDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.testng.annotations.Test;

/**
 * 
 */
public class JaversTest {
	
	@Test
	void test() {
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setId(2);
		s1.setName("aaa");
		
		s2.setId(1);
		s2.setName("aaa");
		
		
		Javers javers=JaversBuilder.javers().build();
		
		Diff diff=javers.compare(s1, s2);
		
		System.out.println(diff.prettyPrint());
		System.out.println(diff.getChanges());
		
		
		
//		Diff:
//			* changes on javersDemo.Student/ :
//			  - 'id' changed: '2' -> '1'
//
//			Changes (1):
//			commit 0.00 
//			* changes on javersDemo.Student/ :
//			  - ValueChange{ property: 'id', left:'2',  right:'1' } 
		
		
		List<Integer> genderList=new ArrayList<Integer>(Arrays.asList(1,5,3,7,9,10,2,4));
		
	int secondLargest=genderList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		
		System.out.println(secondLargest); //9
	}
	
	
	
	
	
	
	
	

}
