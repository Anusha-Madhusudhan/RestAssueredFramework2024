/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 */
public class ExcelUtil {
	

	public static List<Map<String, Object>> getTestDataFromExcel(String path,String sheetName){
		
		List<Map<String, Object>> testData=new ArrayList<Map<String,Object>>();
		
		File f=new File(path);
		
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(f));
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		XSSFSheet sheet=wb.getSheet(sheetName);
		int rowNum=sheet.getLastRowNum();
		int columnNum=sheet.getRow(0).getLastCellNum();
		
		List<String> headers=new ArrayList<String>();
		XSSFRow headerRow=sheet.getRow(0);
		for(int j=0;j<columnNum;j++) {
			 headers.add(headerRow.getCell(j).getStringCellValue());
		}
		
		
		DataFormatter dataFormatter=new DataFormatter();
		for(int i=1;i<=rowNum;i++) {
			Map<String, Object> data=new LinkedHashMap<String, Object>();
			XSSFRow dataRow=sheet.getRow(i);
			for(int j=0;j<columnNum;j++) {
				String dataCellValue=dataFormatter.formatCellValue(dataRow.getCell(j));
				if(j==0) {
					String randomTitle=dataCellValue+"_"+RandomStringUtils.randomAlphabetic(3);
					data.put(headers.get(j), randomTitle);
				}else {
					data.put(headers.get(j), dataCellValue);
				}
				
			}
			testData.add(data);
		}
		
		
		
		try {
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testData;
		
	}

}
