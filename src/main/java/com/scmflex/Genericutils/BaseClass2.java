package com.scmflex.Genericutils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass2
{
	public WebDriverUtils wb=new WebDriverUtils();
	public WebDriver driver;
	public FileUtils fil=new FileUtils();
	
	
	//@Parameters("BROWSER")
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable
	{
		String BROWSER = fil.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Browser is not launched");
			
		}
		
		String URL=fil.readDataFromPropertyFile("url");
		wb.maximizeWindow(driver);
		wb.implictlyWait(driver, 20);
	
		driver.get(URL);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		wb.minimizeWindow(driver);
		driver.quit();
	}

}
