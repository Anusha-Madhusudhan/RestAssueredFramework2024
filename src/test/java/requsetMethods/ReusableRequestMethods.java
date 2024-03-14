/**
 * 
 */
package requsetMethods;

import java.io.File;
import java.util.Map;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reports.ExtentReportListeners;
import reports.ExtentReportManager;

/**
 * 
 */
public class ReusableRequestMethods {

	public static Response postRequest(Map<String, Object> mapPayload, String endPoint, RequestSpecification reqSpec) {

		Response res = RestAssured.given().spec(reqSpec).when().post();

		// Logging Request and response
		ExtentReportManager.logIntoReport(reqSpec, endPoint, res,"POST");

		return res;
	}

	public static void postRequest(String strPayload, String endPoint, Map<String, String> mapHeader) {

	}

	public static void postRequest(File filePayload, String endPoint, Map<String, String> mapHeader) {

	}

	public static Response postRequest(Object pojoPayload, String endPoint, RequestSpecification reqSpec) {

		Response res = RestAssured.given().spec(reqSpec).post();
		// Logging Request and response
		ExtentReportManager.logIntoReport(reqSpec, endPoint, res,"POST");
		return res;
	}

	public static void postRequest(Object pojoPayload, String endPoint, Headers headers) {

	}

	public static Response getRequest(String endPoint, RequestSpecification reqSpec) {
		Response res = RestAssured.given().spec(reqSpec).get(endPoint);

		// Logging Request and response
		ExtentReportManager.logIntoReport(reqSpec, endPoint, res,"GET");

		return res;
	}

}
