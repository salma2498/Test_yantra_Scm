package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Updatestocktest {

	@Test
	public void test() throws IOException, InterruptedException {
		// Read data from properties file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Scm_FlexData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String manufuser = pobj.getProperty("manufacturerusername");
		String manupass = pobj.getProperty("manufacturerpassword");
		String adminuser = pobj.getProperty("adminusername");
		String adminpass = pobj.getProperty("adminpassword");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		// login as a manufacturer
		driver.get(URL);
		driver.findElement(By.name("txtUsername")).sendKeys(manufuser);
		driver.findElement(By.name("txtPassword")).sendKeys(manupass);
		WebElement Logintypedd = driver.findElement(By.id("login:type"));
		Select s = new Select(Logintypedd);
		s.selectByVisibleText("Manufacturer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// dropdown.click();

		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Manufacturer Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Manufacturer Homepage is Not displayed...");
		}

		// click on Add product link
		driver.findElement(By.xpath("//a[text()='Add Products']")).click();

		// Enter data into all textfields
		//FileInputStream fis = new FileInputStream("./src/test/resources/Scmflex.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();

		String unittypedd = sh.getRow(0).getCell(5).getStringCellValue();
		String categorytypedd = sh.getRow(1).getCell(5).getStringCellValue();

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i <= count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}
		for (Entry<String, String> set : map.entrySet()) {

			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());

		}

		// handle unittype dropdown
		WebElement Unittype = driver.findElement(By.xpath("//select[@name='cmbProductUnit']"));

		Select sel = new Select(Unittype);
		sel.selectByVisibleText(unittypedd);

		// handling categorytype dropdown
		WebElement Categortype = driver.findElement(By.xpath("//select[@name='cmbProductCategory']"));
		Select sel2 = new Select(Categortype);
		sel2.selectByVisibleText(categorytypedd);

		// handling Stockmanage radiobuuton

		driver.findElement(By.xpath("//input[@value='1']")).click();

		// handling description textfield
		driver.findElement(By.id("product:description")).sendKeys("Filled with nuts");

		// click on add product button
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		// click on manage stock link
		WebElement managestock = driver.findElement(By.xpath("//a[text()='Manage Stock']"));
		managestock.click();
		// click on chips quantity
		WebElement quantity = driver
				.findElement(By.xpath("//td[text()='238']/parent::tr/descendant::input[@type='text']"));
		quantity.click();
		quantity.clear();
		quantity.sendKeys("10");
		// click on update button
		driver.findElement(By.xpath("//input[@value='Update Stock']")).click();
		// Handle the confirmation popup
		String confirmationMsg = driver.switchTo().alert().getText();
		System.out.println(confirmationMsg);
		driver.switchTo().alert().accept();

		// click on logout as a manufacturer
		// Click on logout button
		WebElement logoutButton = driver.findElement(By.xpath("//input[@value='Log out']"));
		logoutButton.click();

		// Verify login page should be displayed
		String actualloginpageTitle = driver.getTitle();
		System.out.println(actualloginpageTitle);
		String ExpectedLoginpageTitle1 = "";

		// Assert.assertEquals(actualloginpageTitle, ExpectedLoginpageTitle1);
		if (actualloginpageTitle.contains(ExpectedLoginpageTitle1)) {
			System.out.println("Login page is displayed and its verified with title");
		} else {
			System.out.println("Login page is not displayed");
		}
		

		
		WebElement loginbutton2 = driver.findElement(By.cssSelector("input[type='submit']"));
		loginbutton2.click();

		String actualtitle1 = driver.getTitle();
		String expectedtitle1 = "Admin: Home";
		if (actualtitle1.equals(expectedtitle1)) {
			System.out.println("Admin Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Admin Homepage is Not displayed...");
		}

		// click on product link
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		// Update product name along with price
		WebElement textproduct = driver
				.findElement(By.xpath("//td[text()=' 238 ']/following-sibling::td[text()=' Chips ']"));
		String productname = textproduct.getText();

		WebElement productquantity = driver
				.findElement(By.xpath("//td[text()=' 238 ']/following-sibling::td[text()=' 10 ']"));

		String prductQuantity = productquantity.getText();
		System.out.println("Product name : " + productname + " Product Quantity : " + prductQuantity);

		driver.close();
	}

}
