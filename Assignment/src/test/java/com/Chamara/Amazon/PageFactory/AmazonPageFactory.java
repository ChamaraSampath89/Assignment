package com.Chamara.Amazon.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Chamara.Amazon.Utility.WebDriverHelper;

public class AmazonPageFactory {
	//private static AmazonPageFactory amazonPageFactory;
	
//	private AmazonPageFactory() {
//		
//	}
	
	public static AmazonPageFactory getAmazonPageFactory = PageFactory.initElements(WebDriverHelper.getWebDriver(),AmazonPageFactory.class);
	
	@FindBy(how = How.XPATH, using = "//a[@id='nav-logo-sprites']")
	public WebElement HomepageLogo;
	
	@FindBy(how = How.XPATH, using = "//select[@id='searchDropdownBox']")
	public WebElement HomePageSelectDD;
	
	@FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
	public WebElement HomePageItemSearchTXT;
	
	@FindBy(how = How.XPATH, using = "//input[@id='nav-search-submit-button']")
	public WebElement HomePageItemSearchBTN;
	
	@FindBy(how = How.XPATH, using = "//section[@aria-label='4 Stars & Up']")
	public WebElement CustomerReview;
	
	@FindBy(how = How.XPATH, using = "//div[@id='filters']//child::span[text()='Language']//parent::div//following-sibling::ul[1]//child::span[text()='English']")
	public WebElement Language;
	
	@FindBy(how = How.XPATH, using = "//span[@class='a-size-medium a-color-base a-text-normal']")
	public List <WebElement> SearchResultsItemName;
	
	@FindBy(how = How.XPATH, using = "//span[@id='price']")
	//@FindBy(how = How.XPATH, using = "//span[text()=' Buy new: ']//ancestor::h5//child::span[@data-a-color='price']")
	public WebElement SelectedItemUnitPrice;
	
	@FindBy(how = How.XPATH, using = "//span[@id='productTitle']")
	public WebElement DetailPageProductName;
	
	@FindBy(how = How.XPATH, using = "//span[text()='The Titanium Economy: How Industrial Technology Can Create a Better, Faster, Stronger America' and @class='a-truncate-cut']")
	public WebElement ShopingCartProductName;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Qty:']")
	public WebElement QuantityDD;
	
	@FindBy(how = How.XPATH, using = "//div[@id='a-popover-3']//child::ul/li")
	public List <WebElement> QuantityDDValues;
	
	@FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button']")
	public WebElement AddToCartBTN;
	
	@FindBy(how = How.XPATH, using = "//span[@id='sw-gtc']//child::a")
	public WebElement GoToCartBTN;
	
	@FindBy(how = How.XPATH, using = "//span[@id='sc-subtotal-label-activecart']")
	public WebElement QuantitySelected;
	
	@FindBy(how = How.XPATH, using = "//span[@id='sc-subtotal-amount-activecart']/span")
	public WebElement TotalPrice;
	
	@FindBy(how = How.XPATH, using = "//span[@data-feature-id='delete']//child::input")
	public WebElement DeleteOption;

}
