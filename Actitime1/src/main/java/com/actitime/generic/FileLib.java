package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is a Generic Class for Data Driven Testing
 * @author ARJUN
 *
 */
public class FileLib {
	/**
	 * Generic method for returning data from property file
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	
	/**
	 * Generic method for returning data from excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public String getExcelData(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./data/actitimescript.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		String data = w.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	/**
	 * Generic method for writing data to excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public void setExcelData(String sheetname, int row, int cell, String value) throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./data/actitimescript.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		w.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/actitimescript.xlsx");
		w.write(fos);
		w.close();
	}
}
