/**
 * 
 */
package utility;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

/**
 * 
 */
public class FakerDataGenerator {
	
	public static Faker faker=new Faker();
	
	
	public static String getRandomFirstName() {
		return faker.name().firstName();
	}
	
	public static String getRandomLastName() {
		return faker.name().lastName();
	}

	public static String getRandomCity() {
		return faker.address().city();
	}
	
	public static long getRandomNumber() {
		return faker.number().randomNumber(10, true);
	}
	
	public static String getRandomWebsite() {
		return "https://"+RandomStringUtils.randomAlphabetic(8)+".com";
	}
	
}
