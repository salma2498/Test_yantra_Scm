package Practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon_test {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> productname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> productprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0;i<productname.size();i++)
		{
			String productna=productname.get(i).getText();
			String productpri=productprice.get(i).getText();
			String r=productpri.replace(",", "");
			int p=Integer.parseInt(r);
			if(p<=60000)
			{
			System.out.println(productna+"  "+productpri+" ");
			}
		
		
		
			
		
		}

	}

}
