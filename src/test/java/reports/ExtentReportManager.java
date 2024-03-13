/**
 * 
 */
package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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

}
