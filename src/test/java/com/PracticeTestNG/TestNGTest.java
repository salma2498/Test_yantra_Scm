package com.PracticeTestNG;

import org.testng.annotations.Test;

public class TestNGTest {
	@Test
	public void bcreateTest()
	{
		System.out.println("Created");
	}
	
	
	@Test 
	public void xeditTest()
	{
		System.out.println("Edited");
	}
	
	
	@Test(dependsOnMethods = "modifyTest")
	public void deleteTest()
	{
		System.out.println("Deleted");
	}
	
	
	@Test
	public void modifyTest()
	{
		System.out.println("Modified");
	}



}
