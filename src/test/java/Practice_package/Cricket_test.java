package Practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cricket_test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		Thread.sleep(2000);
		List<WebElement> Names = driver.findElements(By.xpath("//table/tbody/tr/td/span[@class='u-hide-phablet']"));
		List<WebElement> matches = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3]"));
		List<WebElement> pos = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for(int i=0;i<Names.size();i++)
		{
			String countryName=Names.get(i).getText();
			String countrymat=matches.get(i).getText();
			String countrypos=pos.get(i).getText();
			System.out.println(countryName+""+countrymat+""+countrypos+"");
		}
		
	}
}
	
	


