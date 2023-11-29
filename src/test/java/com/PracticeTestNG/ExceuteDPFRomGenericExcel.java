package com.PracticeTestNG;

import org.testng.annotations.Test;

public class ExceuteDPFRomGenericExcel {
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataFromExcel")
	public void getdta(String Xpath,String value)
	{
		System.out.println("Hi"+Xpath +" Bye"    +value);
	}


}
