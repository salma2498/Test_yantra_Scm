package Manufacturer_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.AddProductPage;
import com.ObjectRepo.EditProductPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.LogoutPage;
import com.ObjectRepo.ProductsPage;
import com.scmflex.Genericutils.DatabaseUtils;
import com.scmflex.Genericutils.ExcelUtils;
import com.scmflex.Genericutils.FileUtils;
import com.scmflex.Genericutils.JavaUtils;
import com.scmflex.Genericutils.WebDriverUtils;

public class EditProductendtoendtest {
	JavaUtils jlib = new JavaUtils();
	WebDriverUtils wib = new WebDriverUtils();
	FileUtils fil = new FileUtils();
	DatabaseUtils dib = new DatabaseUtils();
	ExcelUtils exel = new ExcelUtils();

	@Test
	public void editproduct() throws Throwable {
		// get the data from the property files

		String Browser = fil.readDataFromPropertyFile("browser");
		String URL = fil.readDataFromPropertyFile("url");
		String manufuser = fil.readDataFromPropertyFile("manufacturerusername");
		String manupass = fil.readDataFromPropertyFile("manufacturerpassword");
		String adminuser = fil.readDataFromPropertyFile("adminusername");
		String adminpass = fil.readDataFromPropertyFile("adminpassword");
		String adminloginty = fil.readDataFromPropertyFile("adminlogintype");
		String manulogintype = fil.readDataFromPropertyFile("manufacturerlogintype");

		WebDriver driver = new ChromeDriver();
		wib.maximizeWindow(driver);
		wib.implictlyWait(driver, 20);
		driver.get(URL);

		// login as a manufacturer
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameAndPassword(manufuser, manupass);
		lp.EnterloginType(manulogintype);
		lp.clickOnLoginButton();

		// click on Add product link
		HomePage hp = new HomePage(driver);
		hp.clickonaddproductlink();

		// Enter data into all textfields
		// using single dta
		/*
		 * String Productname = exel.readDataFromExcel("Sheet1", 0, 1); String
		 * Productprice=exel.readDataFromExcel("Sheet1", 1, 1); String unittypedd =
		 * exel.readDataFromExcel("Sheet1", 0, 5); String cateorydd =
		 * exel.readDataFromExcel("Sheet1", 1, 5); String
		 * Description=exel.readDataFromExcel("Sheet1", 2, 1);
		 */
		AddProductPage addpro = new AddProductPage(driver);
		// Ap.EnterDataIntoAddProductTextfields(Productname, Productprice, unittypedd,
		// cateorydd, Description);
		// using multiple data from excel
		addpro.clickonEnableradiobtn();
		addpro.EnterDataIntoAddProductTextfields(exel.readMultipleData("Sheet1"), driver);
		addpro.clickOnAddProductbtn();

		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		wib.acceptAlert(driver);

		// click on products link
		hp.clickOnProductsLink();

		// Edit the product chocolate
		ProductsPage prop = new ProductsPage(driver);
		prop.clickonedit();

		String Editprice = exel.readDataFromExcel("Sheet1", 0, 8);
		EditProductPage ep = new EditProductPage(driver);
		ep.ClickAndEditProductPrice(Editprice);

		// handling Stockmanage radiobutton
		ep.EditEnablebutton();

		// handling update product button
		prop.clickOnUpdateProduct();

		// Handle alert and print the text
		String updatetext = driver.switchTo().alert().getText();
		System.out.println(updatetext);
		wib.acceptAlert(driver);

		// logout as manufacturer
		LogoutPage lop = new LogoutPage(driver);
		lop.clickOnLogoutButton();

		// verify login page is displayed
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String Expectedtitle = "";

		if (actualtitle.equals(Expectedtitle)) {
			System.out.println("Login page is displayed");
		} else {
			System.out.println("Login page is not displayed");
		}

		// login as admin
		lp.enterUsernameAndPassword(adminuser, adminpass);
		lp.EnterloginType(adminloginty);
		lp.clickOnLoginButton();

		// click on products link
		hp.clickOnProductsLink();

		// print product name along with value
		WebElement productext = driver.findElement(By.xpath("//td[text()=' 251 ']/following-sibling::td[text()=' Choclate ']"));
		String Proname = productext.getText();
		WebElement productprice = driver.findElement(By.xpath("//td[text()=' 251 ']/following-sibling::td[text()=' 120.000 ']"));
		String Proprice = productprice.getText();

		System.out.println("Updated product name  : " + Proname + "  " + " updated price: " + productprice);

		Thread.sleep(2000);

		driver.close();

	}

}
