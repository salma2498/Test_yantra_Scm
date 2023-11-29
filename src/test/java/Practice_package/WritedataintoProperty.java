package Practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritedataintoProperty {

	public static void main(String[] args) throws IOException {
		// create object for prpoperties class
		Properties pobj=new Properties();
		pobj.setProperty("Browser", "Chrome");
		pobj.setProperty("url", "http://rmgtestingserver:8888/");
		pobj.setProperty("UN", "admin");
		pobj.setProperty("pwd", "admin");
		
		//create obj for fileoutputstream
		FileOutputStream fout=new FileOutputStream("./src/test/resources/CommonDataProperties");
		pobj.store(fout, "Write data");
		
		FileInputStream fi=new FileInputStream("./src/test/resources/CommonDataProperties");
		
		pobj.load(fi);
		
		String Browser=pobj.getProperty("Browser");
		String url=pobj.getProperty("url");
		String Username=pobj.getProperty("UN");
		String Password=pobj.getProperty("pwd");
		
		/*System.out.println(Browser);
		System.out.println(url);
		System.out.println(Username);
		System.out.println(Password);*/
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String ele = driver.findElement(By.xpath("//a[text()='how']/../../descendant::a[text()='Refrigerator']")).getText();
		pobj.setProperty("how", ele);
		FileOutputStream fos= new FileOutputStream("./src/test/resources/CommonDataProperties");
		pobj.store(fos, "write data");
		FileInputStream fiss1=new FileInputStream("./src/test/resources/CommonDataProperties");
		pobj.load(fiss1);
		System.out.println(ele);
		
		driver.close();
		
		
		
		

	}

}
