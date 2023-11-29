package Practice_package;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Olympic_test {

	public static void main(String[] args) throws InterruptedException {
		String country = "Argentina";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes, I am happy')]")).click();
		
		

	}

}
