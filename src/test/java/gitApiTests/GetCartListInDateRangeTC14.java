/**
 * 
 */
package gitApiTests;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import requsetMethods.ReusableRequestMethods;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
/**
 * 
 */
public class GetCartListInDateRangeTC14  extends BaseTest{
	
	@Test
	void validateGetCartListInDateRange() {
		
		Map<String, String> queryParams=new LinkedHashMap<String, String>();
		queryParams.put("startdate", "2019-12-10");
		queryParams.put("enddate", "2020-10-10");
		
		Response res=ReusableRequestMethods.getRequest("", reqSpe,queryParams);
		
		
		List<String> dates=res.jsonPath().getList("date");
		
		for(String date:dates) {
			System.out.println(date);
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			Date d = null;
			try {
			    d = df.parse(date);
			    String newDateString = df.format(d);
			    System.out.println(newDateString);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			
			
			
			System.out.println(d);
			
			
			SimpleDateFormat actualDateFormate = new SimpleDateFormat("yyyy-MM-dd"); 
			Date actualStartDate = null;
			Date actualEndDate = null;
			try {
				actualStartDate = actualDateFormate.parse("2019-12-10");
				actualEndDate=actualDateFormate.parse("2020-10-10");
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			assertThat(d, lessThanOrEqualTo(actualEndDate));
			assertThat(d, greaterThanOrEqualTo(actualStartDate));
		}
		
		System.out.println(res.body().asPrettyString());
		
	}

}
