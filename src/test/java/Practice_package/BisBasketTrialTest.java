package Practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scmflex.Genericutils.WebDriverUtils;

public class BisBasketTrialTest {

	public static void main(String[] args) {
		WebDriverUtils wb=new WebDriverUtils();
		WebDriver driver=new ChromeDriver();
		wb.maximizeWindow(driver);
		wb.implictlyWait(driver, 20);
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.id("headlessui-menu-button-:R5bab6:")).click();
		
	}

}
