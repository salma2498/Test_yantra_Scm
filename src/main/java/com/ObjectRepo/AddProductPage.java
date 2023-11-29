package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scmflex.Genericutils.WebDriverUtils;

public class AddProductPage extends WebDriverUtils {
	
	//Declaration
	@FindBy(id="product:name")
	private WebElement productName;
	
	@FindBy(id="product:price")
	private WebElement productPrice;
	
	@FindBy(xpath="//select[@id='product:unit']")
	private WebElement unitTypedd;
	
	@FindBy(xpath="//select[@id='product:category']")
	private WebElement categorytypedd;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement enableRadiobtn;
	
	@FindBy(xpath="")
	private WebElement disableRadiobtn;
	
	@FindBy(id="product:description")
	private WebElement description;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement addProductBtn;
	
	//initializatiion
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getUnitTypedd() {
		return unitTypedd;
	}

	public WebElement getCategorytypedd() {
		return categorytypedd;
	}

	public WebElement getEnableRadiobtn() {
		return enableRadiobtn;
	}

	public WebElement getDisableRadiobtn() {
		return disableRadiobtn;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	
	//Buisness logics
	public void EnterDataIntoAddProductTextfields(String pname,String price,String unittype,String category,String descript)
	{
		
		productName.sendKeys(pname);
		productPrice.sendKeys(price);
		dropdownByVisibleText(unitTypedd, unittype);
		unitTypedd.sendKeys(unittype);
		dropdownByVisibleText(categorytypedd, category);
		categorytypedd.sendKeys(category);
		enableRadiobtn.click();
		description.sendKeys(descript);
		addProductBtn.click();
		
		
		
	}
	
	public void EnterDataIntoAddProductTextfields(HashMap<String, String> map, WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
		
	}
	public void clickOnAddProductbtn()
	{
		addProductBtn.click();
	}
	public void clickonEnableradiobtn()
	{
		enableRadiobtn.click();
	}
	
	
	

}
