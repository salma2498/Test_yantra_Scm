package Practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_Popuptest {

	public static void main(String[] args) {
		//lAUNCH BROWSER
		WebDriver driver=new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//url
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		//wait page load 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//click on departure
		driver.findElement(By.id("txtJourneyDate")).click();
		
		//select the date
		driver.findElement(By.xpath("//span[text()='November']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='11']")).click();
		
	}

}
