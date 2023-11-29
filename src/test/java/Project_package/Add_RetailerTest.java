package Project_package;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;


import com.ObjectRepo.HomePage;

import com.scmflex.Genericutils.BaseClass;

@Listeners(com.scmflex.Genericutils.ListenerClass.class)
public class Add_RetailerTest extends BaseClass {
	
	@Test
	public void addretailer() throws InterruptedException, IOException
	{
				
		//validating home page is displayed
		HomePage hp=new HomePage(driver);
		
		hp.AddProductConfirmatio(driver);
		System.out.println("Home page is Displayed");
		Assert.fail();
		//handling Add Retailer link
		hp.clickOnAddRetailersLink();
		
		//validating retailer page is displayed
		hp.AddRetailerPageConfirmation(driver);
		System.out.println("Retailer page displayed successfully");
		
		
		
	}

}
