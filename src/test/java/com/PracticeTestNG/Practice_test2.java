package com.PracticeTestNG;

import org.testng.annotations.Test;

import com.scmflex.Genericutils.BaseClass2;

public class Practice_test2 extends BaseClass2 {
	@Test(groups = "smoke")
	public void test4()
	{
		System.out.println("test 1");
	}
	@Test(groups ={"smoke","regression"})
	public void test5()
	{
		System.out.println("test 2");
	}


}
