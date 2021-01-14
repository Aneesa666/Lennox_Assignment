package com.lennox.automation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lennox.automation.model.LocatorDto;
import com.lennox.automation.model.TestDataDto;

public class ExcelUtils {
	private static final String EXCEL_LOCATION = System.getProperty("user.dir")
			+ "\\src\\main\\java\\resources\\Testdata\\Testdata.xlsx";
	private static final String FILE_LOCATION = System.getProperty("user.dir")
			+ "\\src\\main\\java\\resources\\Testdata\\";
	public static File file = new File(EXCEL_LOCATION);
	public static FileInputStream fout;
	public static Workbook wb;
	public static Map<String, String> values = new HashMap<>();
	public static Map<String, LocatorDto> locatorValues = new HashMap<>();
	public static Map<String, TestDataDto> testDataValues = new HashMap<>();

	public static void readBrowserProps() throws IOException {
		fout = new FileInputStream(file);
		wb = new XSSFWorkbook(fout);
		Sheet sh = wb.getSheet("Browser");
		Cell keyCell = sh.getRow(0).getCell(0);
		Cell valueCell = sh.getRow(0).getCell(1);
		values.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
	}

	public static void readEnvProps() throws IOException {
		fout = new FileInputStream(file);
		wb = new XSSFWorkbook(fout);
		Sheet sh = wb.getSheet("Environment details");
		int lastRowNum = sh.getLastRowNum();
		for (int i = 0; i <= lastRowNum; i++) {
			Cell keyCell = sh.getRow(i).getCell(0);
			Cell valueCell = sh.getRow(i).getCell(1);
			values.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
		}
	}

	public static void locatorProps() throws IOException {
		fout = new FileInputStream(file);
		wb = new XSSFWorkbook(fout);
		Sheet sh = wb.getSheet("Locators");
		int lastRowNum = sh.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			Cell locatorName = sh.getRow(i).getCell(0);
			Cell locatorValue = sh.getRow(i).getCell(1);
			Cell locatorType = sh.getRow(i).getCell(2);
			LocatorDto locatorDto = new LocatorDto();
			locatorDto.setLocatorName(locatorValue.getStringCellValue());
			locatorDto.setLocatorValue(locatorType.getStringCellValue());
			locatorValues.put(locatorName.getStringCellValue(), locatorDto);
		}
	}

	public static void testDataProps() throws IOException {
		Random random = new Random(); 
		int randomValue =random.nextInt(1000);
		fout = new FileInputStream(file);
		wb = new XSSFWorkbook(fout);
		Sheet sh = wb.getSheet("Testdata");
		int lastRowNum = sh.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			Cell firstNameCell = sh.getRow(i).getCell(0);
			Cell lastNameCell = sh.getRow(i).getCell(1);
			Cell phoneNoCell = sh.getRow(i).getCell(2);
			Cell emailCell = sh.getRow(i).getCell(3);
			Cell requestDateCell = sh.getRow(i).getCell(4);
			DataFormatter formatter = new DataFormatter();
			Cell requestTimeCell = sh.getRow(i).getCell(5);
			Cell documentPathCell = sh.getRow(i).getCell(6);
			Cell optionCell = sh.getRow(i).getCell(7);
			Cell imagePathCell = sh.getRow(i).getCell(8);
			TestDataDto testDataDto = new TestDataDto();
			testDataDto.setFirstName(firstNameCell.getStringCellValue() + randomValue);
			testDataDto.setLastName(lastNameCell.getStringCellValue());
			testDataDto.setPhone(phoneNoCell.getStringCellValue());
			testDataDto.setEmail(emailCell.getStringCellValue());
			testDataDto.setRequestDate(formatter.formatCellValue(requestDateCell));
			testDataDto.setRequestTime(formatter.formatCellValue(requestTimeCell));
			try {
				testDataDto.setDocumentPath(FILE_LOCATION + documentPathCell.getStringCellValue());
			} catch (NullPointerException e) {
				testDataDto.setDocumentPath(StringUtils.EMPTY);
			}
			testDataDto.setOption(optionCell.getStringCellValue());
			try {
				testDataDto.setImagePath(FILE_LOCATION + imagePathCell.getStringCellValue());
			} catch (NullPointerException e) {
				testDataDto.setImagePath(StringUtils.EMPTY);
			}
			testDataValues.put("TestData" + (i - 1), testDataDto);
		}
	}
}