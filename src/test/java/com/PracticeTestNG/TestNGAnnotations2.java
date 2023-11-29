package com.PracticeTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotations2 {
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Beforesuuite");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Beforeclass1");
	}
	@BeforeClass
	public void beforeClass2()
	{
		System.out.println("Beforeclass2");
	}

		
	@BeforeMethod
	public void beforeMethod1()
	{
		System.out.println("BM1");
	}
	@Test
	public void test1()
	{
		System.out.println("Test1");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AM1");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("afterclass1");
	}
	@Test
	public void test2()
	{
		System.out.println("Test2");
	}
	@BeforeMethod
	public void beforeMethod2()
	{
		System.out.println("BM2");
	}
	@AfterClass
	public void afterclass2()
	{
		System.out.println("afterclass2");
	}
	@BeforeMethod
	public void beforeMethod3()
	{
		System.out.println("BM3");
	}
	@AfterMethod
	public void afterMethod2()
	{
		System.out.println("AM2");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Aftersuuite");
	}
	
	

	
	
	

}
