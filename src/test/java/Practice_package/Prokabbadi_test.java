package Practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prokabbadi_test {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String CustomizedTeamName="Dabang Delhi K.C.";
		WebElement Team = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']"));
		String TeamName = Team.getText();
		
		//Point
		WebElement P = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-play']"));
		String Point = P.getText();
		
		//Win
		WebElement W = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-won']"));
		String Win = W.getText();
		
		//Lost
		WebElement L = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-lost']"));
		String Lost = L.getText();
		
		//Tie
		WebElement T = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-draw']"));
		String Tie = T.getText();
		
		//Score Diff
		WebElement SD = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data score-diff']"));
		String ScoreDiff = SD.getText();
		
		//Form
		WebElement F1 = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']/li[1]"));
		String Form1 = F1.getText();
		WebElement F2 = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']/li[2]"));
		String Form2 = F2.getText();
		WebElement F3 = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']/li[3]"));
		String Form3 = F3.getText();
		WebElement F4 = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']/li[4]"));
		String Form4 = F4.getText();
		WebElement F5 = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']/li[5]"));
		String Form5 = F5.getText();
		
		
		//Pts
		WebElement pts = driver.findElement(By.xpath("//p[text()='"+CustomizedTeamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data points']"));
		String Points = pts.getText();
		
		
		//Printing Detals
		System.out.println(TeamName+"  "+Point+"  "+Win+"  "+Lost+"  "+Tie+"  "+ScoreDiff+"  "+Form1+"  "+Form2+"  "+Form3+"  "+Form4+"  "+Form5+"  "+Points);
		
		driver.quit();

	}

}
