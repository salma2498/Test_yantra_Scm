package Practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CmdParameterTest {
	@Test
	public void parametertest()
	{
		String BRowser=System.getProperty("Browser");
		String URL=System.getProperty("url");
		String UN=System.getProperty("username");
		String Pwd=System.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='how']/../../descendant::a[text()='Refrigerator']")).getText();
		System.out.println(BRowser);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(Pwd);
		
	}

}
