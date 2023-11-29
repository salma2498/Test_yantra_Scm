package com.scmflex.Genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	/**
	 * This method is used to read data from excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value=sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	/**
	 * This method is used to get the total row count
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write the data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName,int row, int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
	    sh.createRow(row).createCell(cell).setCellValue(data);
	    FileOutputStream fout=new FileOutputStream(IPathConstants.Excelpath);
	    wb.write(fout);
	    wb.close();
	}
	/**
	 * This method is used to read the multiple data into excel
	 * @param sheetName
	 * @param driver
	 * @return 
	 * @throws Throwable
	 */
	public HashMap<String, String> readMultipleData(String sheetName) throws Throwable
	{
		JavaUtils jlib=new JavaUtils();
		FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String,String>();
		
		
		for (int i = 0; i <=count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		
		return map;
		}
	
	public Object[][] getMultipleSetOfData(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		int rowcount = sh.getPhysicalNumberOfRows();
		int cellcount=sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for (int j = 0; j < cellcount; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
		 
		
	}
		
}
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

