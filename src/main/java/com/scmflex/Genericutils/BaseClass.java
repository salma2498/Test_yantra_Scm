package com.scmflex.Genericutils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.LogoutPage;

public class BaseClass {
	public DatabaseUtils db=new DatabaseUtils();
	public FileUtils fil=new FileUtils();
	public WebDriverUtils wb=new WebDriverUtils();
	public ExcelUtils exel= new ExcelUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable
	
	{
		db.connectDB();
		System.out.println("Database connected");
	}
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable
	{
		String BROWSER=fil.readDataFromPropertyFile("browser");
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
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wb.maximizeWindow(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable
	{
		String URL=fil.readDataFromPropertyFile("url");
		String UN=fil.readDataFromPropertyFile("adminusername");
		String pwd=fil.readDataFromPropertyFile("adminpassword");
		String logintype=fil.readDataFromPropertyFile("adminlogintype");
		
		driver.get(URL);
		
		wb.implictlyWait(driver, 30);
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameAndPassword(UN, pwd);
		lp.EnterloginType(logintype);
		lp.clickOnLoginButton();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		LogoutPage lo=new LogoutPage(driver);
		lo.clickOnLogoutButton();
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_As() throws Throwable
   {
		db.disconnectDB();
		System.out.println("Database closed");
	}
	

}
