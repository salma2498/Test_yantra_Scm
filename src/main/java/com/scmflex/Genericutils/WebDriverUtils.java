package com.scmflex.Genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils {

	/**
	 * This method is used to maximize the window
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to minimize the window
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait for the page load
	 */
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	/**
	 * This method is used to implicitly wait
	 */
	
	public void implictlyWait(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * This method is used to wait until the element is visible
	 */
	public void waitElementToBeVisible(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to wait until the element is clickable
	 */
	public void waitElementToBeClickable(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to handle the dropdown by index
	 * @param index
	 */
	public void dropdownByIndex(int index,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method is used to handle the dropdown by value
	 * @param value
	 */
	public void dropdownByvalue(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method is used to handle the dropdown by visible text
	 * @param text
	 */
	public void dropdownByVisibleText(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method is used to handle the doubleclick
	 */
	public void doubleClick(WebDriver driver)
	{
	Actions act=new Actions(driver);
	act.doubleClick().click().perform();
	}
	/**
	 * This method is used to drag and drop
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, target).perform();
	}
	/**
	 * This method is used to double click on element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on the webpage
	 */
	public void rightClickOnWebPage(WebDriver driver)
	{
	Actions act=new Actions(driver);
	act.contextClick().click().perform();
	}
	/**
	 * This method is used to right click on the webelement
	 */
	public void rightClickOnWebElement(WebDriver driver,WebElement element)
	{
	Actions act=new Actions(driver);
	act.contextClick(element).click().perform();
	}
	/**
	 * This method is used to keypress enter by using actions
	 */
	public void keyPress(WebDriver driver)
	{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to keypress enter by using robot
	 * @throws Throwable
	 */
	public void keyPressEnter() throws Throwable
	{
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to keyrelease enter by using robot
	 * @throws Throwable
	 */
	public void keyReleaseEnter() throws Throwable
	{
	Robot rb=new Robot();
	rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch the frame by index
	 * @param index
	 */
	public void switchToFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame by name or id
	 * @param nameorid
	 */
	public void switchToFrameByFrameName(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method is used to switch the frame by adress of element
	 * @param address
	 */
	public void switchToFrameByElement(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * This method will switch between windows
	 * @param partialwintitle
	 */
	public void switchToWindow(WebDriver driver,String partialwintitle)
	{
		//step1:use getwindowhandles to capture all windowids
		Set<String>windows=driver.getWindowHandles();
		//step2 : iiterate through the windows
		Iterator<String>it=windows.iterator();
		//step3 check whteher there is next window
		while(it.hasNext())
		{
			//step4:capture cureent window id
			String winId=it.next();
			//step5:switch to current window and capture title
			String currentWinTitle=driver.switchTo().window(winId).getTitle();
			//step6:check whether the current window is expected
			if(currentWinTitle.contains(partialwintitle))
			{
				break;
			}
		}
	}
	/**
	 * This method will accept alert popup
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel alert popup
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will perform the mousehover actions
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will take a screenshot and store it folder
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String path=".\\screenshot\\"+screenShotName+".png";
		 File dst=new File(path);
		 FileUtils.copyFile(src, dst);
		 return dst.getAbsolutePath();
		
	}
	/**
	 * This method will perform random scroll(webpage)
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	/**
	 * This method will scroll until the specified elemt is found
	 */
	public void scrollActionuntilElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
		js.executeScript("argument[0].scrollIntoView()", element);
	}
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
