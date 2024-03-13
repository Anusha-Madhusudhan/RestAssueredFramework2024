/**
 * 
 */
package reports;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * 
 */
public class ExtentReportListeners implements ITestListener {

	public static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onStart(ITestContext context) {
		String reportPath = System.getProperty("user.dir") + "\\reports\\"
				+ ExtentReportManager.getReportNameTimeStamp();
		extentReports = ExtentReportManager.createInstance(reportPath, "Test Api Automation Report", "Test Api Report");
	}

	public void onTestStart(ITestResult result) {
		ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass(MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
		extentTest.get().info(result.getThrowable().getMessage());
	    String stackTrace=Arrays.toString(result.getThrowable().getStackTrace());
	    
	    
	
	    extentTest.get().info(stackTrace.replaceAll(",", "<br>"));
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.YELLOW));
	}

	public void onFinish(ITestContext context) {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

}
