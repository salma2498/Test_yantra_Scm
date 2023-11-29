package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRetailerPage {
	//Decalration
	@FindBy(id="retailer:username")
	private WebElement retaiUsername;

	
	  @FindBy(id="retailer:password")
	  private WebElement retaipassword;
	  
	  @FindBy(xpath="//select[@id='retailer:areaCode']") 
	  private WebElement retaiareacodedd;
	  
	  @FindBy(id="retailer:phone") 
	  private WebElement retaiPhoneno;
	  
	  @FindBy(id="retailer:email")
	  private WebElement retailEmail;
	  
	  @FindBy(xpath="//textarea[@id='retailer:address']")
	  private WebElement retailAddress;
	  
	  @FindBy(xpath="//input[@type='submit']")
	  private WebElement addRetailerBtn;
	  
	  //Initialization
	  public AddRetailerPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
 
	  //Utilization
	public WebElement getRetaiUsername() {
		return retaiUsername;
	}

	public WebElement getRetaipassword() {
		return retaipassword;
	}

	public WebElement getRetaiareacodedd() {
		return retaiareacodedd;
	}

	public WebElement getRetaiPhoneno() {
		return retaiPhoneno;
	}

	public WebElement getRetailEmail() {
		return retailEmail;
	}

	public WebElement getRetailAddress() {
		return retailAddress;
	}

	public WebElement getAddRetailerBtn() {
		return addRetailerBtn;
	}
	  
	  
	  //Buisness logics
	public void EnterDtatocreateRetailer(HashMap<String, String> map,WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
	}
	  public void clickOnAddRetailerBtn()
	  {
		  addRetailerBtn.click();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
