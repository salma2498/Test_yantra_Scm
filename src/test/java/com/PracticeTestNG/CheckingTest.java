package com.PracticeTestNG;

import org.testng.annotations.Test;

public class CheckingTest {
	@Test
	public void createTest()
	{
		int[]a= {1,2,3,4,5};
		System.out.println(a[10]);
	}
	@Test
	public void editTest()
	{
		System.out.println("Edit test");
	}
	@Test(dependsOnMethods = "createTest")
	public void deleteTest()
	{
		System.out.println("delete test");
	}
	

	

}
