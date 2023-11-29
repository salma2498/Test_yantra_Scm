package Project_package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.MyOrderPage;
import com.ObjectRepo.RetailerHomePage;
import com.scmflex.Genericutils.DatabaseUtils;
import com.scmflex.Genericutils.ExcelUtils;
import com.scmflex.Genericutils.FileUtils;
import com.scmflex.Genericutils.JavaUtils;
import com.scmflex.Genericutils.WebDriverUtils;

public class SearchOrdersTest {

	public static void dropdown(WebElement Element, String text) {
		Select sel = new Select(Element);
		sel.selectByVisibleText(text);

	}

	public static void main(String[] args) throws Throwable {
		FileUtils file = new FileUtils();
		JavaUtils jv = new JavaUtils();
		ExcelUtils exel = new ExcelUtils();
		DatabaseUtils db = new DatabaseUtils();
		WebDriverUtils wb = new WebDriverUtils();

		WebDriver driver = new ChromeDriver();
		wb.maximizeWindow(driver);

		// get the data from the property files
		String Browser = file.readDataFromPropertyFile("browser");
		String URL = file.readDataFromPropertyFile("url");
		String retaileruser = file.readDataFromPropertyFile("retailerusername");
		String retailerpass = file.readDataFromPropertyFile("retailerpassword");
		String retailerlogintype = file.readDataFromPropertyFile("retailerlogintype");

		// login to application
		wb.implictlyWait(driver, 30);

		// login as a manufacturer
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameAndPassword(retaileruser, retailerpass);
		lp.EnterloginType(retailerlogintype);
		lp.clickOnLoginButton();
		// Validating Homepage is displayed
		String actualhomepage = driver.findElement(By.xpath("//title")).getText();

		System.out.println(driver.getTitle() + " is displayed");

		// Excel Utility

		// search with itemID
		System.out.println("//search with itemID//");
		RetailerHomePage reth = new RetailerHomePage(driver);
		reth.clickOnMyOrdersLink();

		String actualorder = driver.findElement(By.xpath("//title")).getText();

		System.out.println(driver.getTitle() + " is displayed");
		MyOrderPage myor = new MyOrderPage(driver);
		myor.searchbyitemId(exel.readDataFromExcel("Sheet3", 1, 0), exel.readDataFromExcel("Sheet3", 1, 1));
		String actualid = exel.readDataFromExcel("Sheet3", 1, 1);

		String expectedid = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[2]/td[1]"))
				.getText();

		if (actualid.equals(expectedid)) {
			System.out.println("searched with correct id");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.out.println(errormsg);
		}

		// search with item order date
		System.out.println("//search with  item order date//");
		reth.clickOnMyOrdersLink();
		System.out.println(driver.getTitle() + " is displayed");

		myor.searchbyitemDate(exel.readDataFromExcel("Sheet3", 2, 0), "Nov");

		String expdate = "10-11-2023";

		String actualdate = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[2]/td[2]"))
				.getText();
		if (actualdate.contains(expdate)) {
			System.out.println("searched with correct date");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.err.println(errormsg);
		}

		// search with item status as Pending
		System.out.println("//search with item status as  Pending//");
		reth.clickOnMyOrdersLink();

		System.out.println(driver.getTitle() + " is displayed");
		myor.seachbyitemstatus(exel.readDataFromExcel("Sheet3", 3, 0), exel.readDataFromExcel("Sheet3", 3, 2));

		String expstatus = exel.readDataFromExcel("Sheet3", 3, 2);
		String actualstatus = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[2]/td[4]"))
				.getText();

		if (expstatus.contains(actualstatus)) {
			System.out.println("searched with  correct pending status");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.err.println(errormsg);
		}

		// search with item status as completed
		System.out.println("//search with item status as completed//");
		reth.clickOnMyOrdersLink();
		myor.seachbyitemstatus(exel.readDataFromExcel("Sheet3", 3, 0), exel.readDataFromExcel("Sheet3", 3, 3));

		String expstatus1 = exel.readDataFromExcel("Sheet3", 3, 3);
		String actstatus = exel.readDataFromExcel("Sheet3", 3, 2);

		if (actstatus.equals(expstatus1)) {
			System.out.println("searched with completed status");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.err.println(errormsg);
		}

		// search with item approval as approved option
		System.out.println("//search with item approval as approved option//");
		reth.clickOnMyOrdersLink();

		System.out.println(driver.getTitle() + " is displayed");
		myor.seachByItemApprovedoption(exel.readDataFromExcel("Sheet3", 4, 0), exel.readDataFromExcel("Sheet3", 4, 3));

		String expapp = exel.readDataFromExcel("Sheet3", 4, 2);
		String actapp = exel.readDataFromExcel("Sheet3", 4, 3);

		if (expapp.equals(actapp)) {
			System.out.println("searched with  correct approved option");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.err.println(errormsg);
		}

		// search with item approval as not approved option
		System.out.println("//search with item approval as not approved option//");

		System.out.println("//search with item approval as approved option//");
		reth.clickOnMyOrdersLink();

		System.out.println(driver.getTitle() + " is displayed");
		myor.seachByItemApprovedoption(exel.readDataFromExcel("Sheet3", 4, 0), exel.readDataFromExcel("Sheet3", 4, 2));

		String expapp1 = exel.readDataFromExcel("Sheet3", 4, 2);
		String actualapp = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[2]/td[3]"))
				.getText();
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		if (expapp1.contains(actualapp)) {
			System.out.println("searched with correct not approved option");
		} else {
			String errormsg = myor.getErrorMessage().getText();
			System.err.println(errormsg);
		}
		driver.quit();
	}

}
