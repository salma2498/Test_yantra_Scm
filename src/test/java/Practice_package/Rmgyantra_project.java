package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Rmgyantra_project {

	public static void main(String[] args) throws InterruptedException, SQLException {
		String expdata="salma_ty24";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//signin to rmg
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		//click on projects
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		Thread.sleep(3000);
		//create project
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("vijaylakshmi");
		WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		Select s=new Select(ele);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//register to database
		
			
	
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		//get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//create statement
		Statement state = con.createStatement();
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		try {
		while(result.next())
		{
			String actual=result.getString(4);
			if(actual.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
			
		}
		if(flag)
		{
			System.out.println("project created successfully");
		}
		else {
			System.out.println("project is not created");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			//close database
			con.close();
			
		}
	
		
		
		
		
		
		
		

	}

}
