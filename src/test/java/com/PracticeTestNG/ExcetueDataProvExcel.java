package com.PracticeTestNG;

import org.testng.annotations.Test;

public class ExcetueDataProvExcel {
	@Test(dataProviderClass = DataProviderExcelTest.class,dataProvider = "data")
	public void getdta(String Xpath,String value)
	{
		System.out.println("Hi"+Xpath +" Bye"  +value);
	}

}
