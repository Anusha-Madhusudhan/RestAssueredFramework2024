/**
 * 
 */
package utility;

import java.io.File;
import java.util.Map;

import io.restassured.path.json.JsonPath;

/**
 * 
 */
public class JsonUtility {

	public static Map<String, String> getJsondataAsMap(File f) {

		Map<String, String> apiMap = JsonPath.from(f).getMap("");

		return apiMap;

	}

	public static Map<String, Object> getJsondataAsMap(String json, String jsonPath) {

		Map<String, Object> apiMap = JsonPath.from(json).getMap(jsonPath);

		return apiMap;

	}

}
