package Practice_package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Broken_links {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.ksrtc.in/oprs-web/");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		ArrayList<String> list=new ArrayList<String>();
		for(WebElement link:alllinks)
		{
			String eachlink=link.getAttribute("href");
			URL url=null;
			int Statuscode=0;
			try {
				url=new URL(eachlink);
				HttpURLConnection httpurlconn=(HttpURLConnection)url.openConnection();
				Statuscode=httpurlconn.getResponseCode();
				if(Statuscode>=400)
				{
					list.add(eachlink);
					System.out.println(eachlink+" "+Statuscode);
				}
			}
				catch(Exception e)
				{
					System.out.println(eachlink+""+Statuscode);
				}
			}
		
		
	}


}
