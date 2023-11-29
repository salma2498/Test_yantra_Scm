package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {
	//Declaration
	@FindBy(id="product:name")
	private WebElement EditProductName;
	
	@FindBy(id="product:price")
	private WebElement EditproductPrice;

	@FindBy(xpath="//select[@id='product:unit']")
	private WebElement EditunitTypedd;
	
	@FindBy(xpath="//select[@id='product:category']")
	private WebElement Editcategorytypedd;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement EditenableRadiobtn;
	
	@FindBy(xpath="")
	private WebElement EditdisableRadiobtn;
	
	@FindBy(id="product:description")
	private WebElement Editdescription;
	
	//initialization
	public EditProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//uitilzation

	public WebElement getEditProductName() {
		return EditProductName;
	}

	public WebElement getEditproductPrice() {
		return EditproductPrice;
	}

	public WebElement getEditunitTypedd() {
		return EditunitTypedd;
	}

	public WebElement getEditcategorytypedd() {
		return Editcategorytypedd;
	}

	public WebElement getEditenableRadiobtn() {
		return EditenableRadiobtn;
	}

	public WebElement getEditdisableRadiobtn() {
		return EditdisableRadiobtn;
	}

	public WebElement getEditdescription() {
		return Editdescription;
	}
	
	//Buisness logics
	public void EditProductName(String editProname)
	{
		EditProductName.sendKeys(editProname);
	}
	public void ClickAndEditProductPrice(String editProprice)
	{
		EditproductPrice.click();
		EditproductPrice.clear();
		EditproductPrice.sendKeys(editProprice);
	}
	public void EditProductunittype(String unittype)
	{
		EditunitTypedd.sendKeys(unittype);
	}
	public void EditProductcategorytype(String categorytype)
	{
		Editcategorytypedd.sendKeys(categorytype);
	}
	public void EditEnablebutton()
	{
		EditenableRadiobtn.click();
	}
	

	

	

}
