package com.PracticeTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scmflex.Genericutils.ExcelUtils;

public class DataProviderTest {
	@Test(dataProvider = "store")
	public void get(String from,String to)
	{
		System.out.println("Travelling from"+from+" To--->"+to);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[2][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Mysore";
		obj[0][2]=400;
		
		obj[1][0]="Hyderabad";
		obj[1][1]="Bangalore";
		obj[1][2]=1000;
		
		return obj;
	}
	
	@DataProvider
	public Object[][] store()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Kerala";
		obj[0][1]="Pollachi";
		
		obj[1][0]="Jammu";
		obj[1][1]="Kashmir";
		return obj;
		
		
		
	}
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable
	{
		ExcelUtils exel=new ExcelUtils();
		Object[][] value=exel.getMultipleSetOfData("Sheet2");
		
		return value;
	}

}
