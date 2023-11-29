package com.PracticeTestNG;

import org.testng.annotations.Test;

import com.scmflex.Genericutils.BaseClass2;

public class Practice_test1  extends BaseClass2{
	
	@Test(groups = "regression")
	public void test1()
	{
		System.out.println("test 1");
	}
	
	
	@Test(groups = "smoke")
	public void test2()
	{
		System.out.println("test 2");
	}
	
	
	@Test(groups = "regression")
	public void test3()
	{
		System.out.println("test 3");
	}




}
