/**
 * 
 */
package reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

/**
 * 
 */
public class ExtentReportManager {
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	
	public static ExtentReports createInstance(String filePath,String reportName,String reportTitle) {
		
		extentSparkReporter=new ExtentSparkReporter(filePath);
		extentSparkReporter.config().setReportName(reportName);
		extentSparkReporter.config().setDocumentTitle(reportTitle);
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setEncoding("utf-8");
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
	

	public static String getReportNameTimeStamp() {
		String timeStamp=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss").format(new Date());
		String reportName="ExtentTestReport"+timeStamp+".html";
		System.out.println(reportName);
		return reportName;
	}
	
	public static void logIntoReport(RequestSpecification reqSpec,String endPoint,Response res,String httpMethod,Map<String, String> queryParams,Object payload) {
	       QueryableRequestSpecification qReqSpe=SpecificationQuerier.query(reqSpec);
	    	 
	    	 
	    	 ExtentReportListeners.extentTest.get().info("Base URI :: "+qReqSpe.getBaseUri());
	    	 ExtentReportListeners.extentTest.get().info("End Point :: "+endPoint);
	    	 if(queryParams!=null) {
	    		 ExtentReportListeners.extentTest.get().info("Query Params :: "+queryParams.toString());
	    	 }
	    	 
	    	 if(payload!=null) {
	    		 ExtentReportListeners.extentTest.get().info("PayLoad :: "+payload.toString());
	    	 }
	    	 
	    	 
	    	 ExtentReportListeners.extentTest.get().info("Http method :: "+httpMethod);
	    	 ExtentReportListeners.extentTest.get().info("Request Headers :: "+qReqSpe.getHeaders().asList().toString());
	    	 
	    	 ExtentReportListeners.extentTest.get().info("Response status code :: "+res.statusCode());
	    	 ExtentReportListeners.extentTest.get().info("Response header :: ");
	    	 
	    	 String[][] headerArray= res.getHeaders().asList().stream().map(header -> new String[] {header.getName(),header.getValue()})
	    	               .toArray(String[][] ::new);
	    	 
	    	
	    	 ExtentReportListeners.extentTest.get().info(MarkupHelper.createTable(headerArray));
	    	 ExtentReportListeners.extentTest.get().info("Response Body is :: ");
	    	 ExtentReportListeners.extentTest.get().info(MarkupHelper.createCodeBlock(res.body().asString(), CodeLanguage.JSON));
	     }

}
