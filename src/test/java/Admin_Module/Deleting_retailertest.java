package Admin_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ObjectRepo.AddProductPage;
import com.ObjectRepo.AddRetailerPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.RetailersPage;
import com.scmflex.Genericutils.BaseClass;
import com.scmflex.Genericutils.DatabaseUtils;
import com.scmflex.Genericutils.ExcelUtils;
import com.scmflex.Genericutils.FileUtils;
import com.scmflex.Genericutils.JavaUtils;
import com.scmflex.Genericutils.WebDriverUtils;
//@Listeners(com.scmflex.Genericutils.ListenerClass.class)
public class Deleting_retailertest extends BaseClass {
	
	

	@Test
	//@Parameters("BROWSER")
	public void deleteretailer() throws Throwable {
		HomePage hp=new HomePage(driver);
		//validating home page is displayed
		hp.AdminHomePageConfirmation(driver);
		System.out.println("Admin Home page is displayed");
		
		// handling Add Retailer link
		hp.clickOnAddRetailersLink();
		
		// validating retailer page is displayed
		hp.AddRetailerPageConfirmation(driver);
		System.out.println("Retailer page displayed successfully");

		
		// Enter data into all textfields
		AddRetailerPage ar=new AddRetailerPage(driver);
		ar.EnterDtatocreateRetailer(exel.readMultipleData("Sheet2"), driver);
		ar.clickOnAddRetailerBtn();
		

		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
    	wb.acceptAlert(driver);

		// handle retailers link
		hp.clickOnRetailersLink();
	
		// select the retailer to be deleted
		RetailersPage rp=new RetailersPage(driver);
		rp.SelectedRetailertobedelted();
		// handle delete button
		rp.ClickOnDeleteButton();
		
		// Handle alert and print the text
		String deletedretailertext = driver.switchTo().alert().getText();
		System.out.println(deletedretailertext);

		wb.acceptAlert(driver);

		

	}

}
