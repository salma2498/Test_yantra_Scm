package Practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flipkart_test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("oneplus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> productname = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		List<WebElement> productprice = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		for(int i=0;i<productname.size();i++)
		{
			String productna=productname.get(i).getText();
			String productpri=productprice.get(i).getText();
			System.out.println(productna+"  "+productpri+" ");
		}
		
	}

}
