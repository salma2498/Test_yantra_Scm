package com.PracticeTestNG;

import org.testng.annotations.Test;

public class ExecuteDataProTest {
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "store")
	public void getData(String from,String to)
	{
		System.out.println("Travelling from"+from+" To--->"+to);
	}

}
