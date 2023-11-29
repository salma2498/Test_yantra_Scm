package Project_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ObjectRepo.AddProductPage;
import com.ObjectRepo.EditProductPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.ProductsPage;
import com.scmflex.Genericutils.BaseClass;
import com.scmflex.Genericutils.DatabaseUtils;
import com.scmflex.Genericutils.ExcelUtils;
import com.scmflex.Genericutils.FileUtils;
import com.scmflex.Genericutils.JavaUtils;
import com.scmflex.Genericutils.WebDriverUtils;

public class AddProductsTest {
	WebDriver driver;
	
	@Test(groups = "Integration")
	@Parameters("BROWSER")
	
	public void product(String BROWSER) throws Throwable {
		// get the data from the property files
		 DatabaseUtils db=new DatabaseUtils();
		 FileUtils fil=new FileUtils();
		 WebDriverUtils wb=new WebDriverUtils();
		 ExcelUtils exel= new ExcelUtils();
	     
	//	String BROWSER = fil.readDataFromPropertyFile("browser");
		String URL = fil.readDataFromPropertyFile("url");
		String manufuser = fil.readDataFromPropertyFile("manufacturerusername");
		String manupass = fil.readDataFromPropertyFile("manufacturerpassword");
		String manulogintype = fil.readDataFromPropertyFile("manufacturerlogintype");

		// login as a manufacturer
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
		driver=new ChromeDriver();
		
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		wb.maximizeWindow(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.enterUsernameAndPassword(manufuser, manupass);
		lp.EnterloginType(manulogintype);
		lp.clickOnLoginButton();
		hp.ManufacturerHomePageConfirmationSA(driver);
		System.out.println("Manufacturer Home page is displayed");

		// click on Add product link
		
		hp.clickonaddproductlink();
		hp.AddProductConfirmatio(driver);
		System.out.println("Add Product page is dispalyed");

		// Enter data into all textfields

		// using single read data from excel
		// String Proname = exel.readDataFromExcel("Sheet1", 0, 1);
		// String Proprice = exel.readDataFromExcel("Sheet1", 1, 1);
		// String unittypedd=exel.readDataFromExcel("Sheet1", 0, 5);
		// String categorytypedd=exel.readDataFromExcel("Sheet1", 1, 5);

		AddProductPage addpro = new AddProductPage(driver);
		// addpro.EnterDataIntoAddProductTextfields(Proname, Proprice,unittypedd ,
		// categorytypedd, Description);
		// using multiple data from excel
		addpro.clickonEnableradiobtn();
		addpro.EnterDataIntoAddProductTextfields(exel.readMultipleData("Sheet1"), driver);
		addpro.clickOnAddProductbtn();

		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		wb.acceptAlert(driver);
		driver.close();

	}

}
