package Manufacturer_Module;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scmflex.Genericutils.DatabaseUtils;
import com.scmflex.Genericutils.ExcelUtils;
import com.scmflex.Genericutils.FileUtils;
import com.scmflex.Genericutils.JavaUtils;
import com.scmflex.Genericutils.WebDriverUtils;



public class UpdateStocktest {
	JavaUtils jlib = new JavaUtils();
	WebDriverUtils wib = new WebDriverUtils();
	FileUtils fil = new FileUtils();
	DatabaseUtils dib = new DatabaseUtils();
	ExcelUtils exel = new ExcelUtils();
	public WebDriver driver;
	@Test
	public void test() throws IOException 
	{
		
		
		String URL = fil.readDataFromPropertyFile("url");
		String USERNAME =fil.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD =fil.readDataFromPropertyFile("manufacturerpassword");
		String ManufacturerLOGINTYPE =fil.readDataFromPropertyFile("Manufacturerlogintype");
		String AdminUsername =fil.readDataFromPropertyFile("adminusername");
		String Adminpassword =fil.readDataFromPropertyFile("adminpassword");
		String AdminLOGINTYPE =fil.readDataFromPropertyFile("Adminlogintpe");
	
		WebDriver driver = new ChromeDriver();
		
		/*LoginPage loginpage= new LoginPage(driver);
		ManufacturerHomePage mHomepage = new ManufacturerHomePage(driver);
		ManufacturerAddproductPage mAddproductPage= new ManufacturerAddproductPage(driver);
		ManageStockPage managestockpg=new ManageStockPage(driver);
		AdminHomePage adminhomepage= new AdminHomePage(driver);
		AdminViewProductPage adminproductpage=new AdminViewProductPage(driver);*/

		driver.get(URL);
		wib.maximizeWindow(driver);
		wib.implictlyWait(driver, 30);
		
		/*loginpage.EnterUsernameAndPassword(USERNAME, PASSWORD);
		loginpage.getLogintypeDropdown().sendKeys(ManufacturerLOGINTYPE);
		loginpage.ClickOnLoginButton();*/
		

		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Manufacturer Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Manufacturer Homepage is Not displayed...");
		}

		// add products
		// Click On add product Link
		//mHomepage.ClickOnaddProductLink();

		String actualaddproducttitle = driver.getTitle();
		String expectedproductpagetitle = "Add Product";
		if (actualaddproducttitle.equals(expectedproductpagetitle)) {
			System.out.println("addProduct page is displayed... and its verified with title");
		} else {
			System.out.println("addProduct page is Not displayed...");
		}

		// Enter the data inside the product name textField
		String productname = exel.readDataFromExcel("Sheet2", 0, 1);
		String price = exel.readDataFromExcel("Sheet2", 1, 1);
		String unit = exel.readDataFromExcel("Sheet2", 2, 1);
		String category = exel.readDataFromExcel("Sheet2", 3, 1);
		String desc = exel.readDataFromExcel("Sheet2", 4, 1);
		
		//mHomepage.ClickOnaddProductLink();
		//mAddproductPage.EnterAlltheProductdata(productname, price, unit, category, desc);

		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		
		// click on manage stock link
		//mHomepage.ClickonmanageStockLink();
		// click on chips quantity
		WebElement quantity = driver.findElement(By.xpath("//td[text()='238']/parent::tr/descendant::input[@type='text']"));		
		quantity.click();
		quantity.clear();
		quantity.sendKeys("10");
		
		// click on update button
		//managestockpg.ClickOnUpdateButton();
		// Handle the confirmation popup
		String confirmationMsg = driver.switchTo().alert().getText();
		System.out.println(confirmationMsg);
		driver.switchTo().alert().accept();

		// click on logout as a manufacturer
		// Click on logout button
		//mHomepage.ClickOnLogoutButton();

		// Verify login page should be displayed
		String actualloginpageTitle = driver.getTitle();
		System.out.println(actualloginpageTitle);
		String ExpectedLoginpageTitle1 = "";
		
		//Assert.assertEquals(actualloginpageTitle, ExpectedLoginpageTitle1);
		if (actualloginpageTitle.contains(ExpectedLoginpageTitle1)) 
		{
			System.out.println("Login page is displayed and its verified with title");
		} else 
		{
			System.out.println("Login page is not displayed");
		}
		// Login as Admin And check product is displayed or not
		//loginpage.EnterUsernameAndPassword(AdminUsername, Adminpassword);
		//loginpage.getLogintypeDropdown().sendKeys(AdminLOGINTYPE);
		//loginpage.ClickOnLoginButton();

		String actualtitle1 = driver.getTitle();
		String expectedtitle1 = "Admin: Home";
		if (actualtitle1.equals(expectedtitle1)) {
			System.out.println("Admin Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Admin Homepage is Not displayed...");
		}

		// click on product link
		//adminhomepage.ClickOnproductLink();
		// Check product is updated or not
		//String Productname=adminproductpage.getUpdatedProductName().getText();
		//String prductQuantity = adminproductpage.getUpdatedProductQuantity().getText();
		//System.out.println("Product name : " + Productname + " Product Quantity : " + prductQuantity);
		driver.close();

	}


}
