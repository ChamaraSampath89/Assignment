package com.Chamara.Amazon.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Chamara.Amazon.PageFactory.AmazonPageFactory;
import com.Chamara.Amazon.Utility.PropertyFileHandler;
import com.Chamara.Amazon.Utility.WebDriverHelper;

public class AmazonPO {
	private static AmazonPO amazonpo;
	static WebDriver driver;
	
	private AmazonPO() {
		
	}
	
	public static AmazonPO getAmazonPO() {
		if(amazonpo == null) {
			amazonpo = new AmazonPO();
		}
		return amazonpo;
	}
	
	public void a(String url) throws InterruptedException {
		WebDriverHelper.getWebDriverHelper().enterURL(url);
	}
	
	public boolean verifyHomepageLogo() {
		return AmazonPageFactory.getAmazonPageFactory.HomepageLogo.isDisplayed();
	}
	
	public String verifyPageTitle() {
		System.out.println("Title:" +WebDriverHelper.getWebDriverHelper().getPageTitle());
		return WebDriverHelper.getWebDriverHelper().getPageTitle();
	}
	
	public void selectDDValue(String dpvalue) {
		Select drpItems = new Select(AmazonPageFactory.getAmazonPageFactory.HomePageSelectDD);
		drpItems.selectByVisibleText(dpvalue);
	}
	
	public void enterValue(String searchitem) {
		AmazonPageFactory.getAmazonPageFactory.HomePageItemSearchTXT.clear();
		AmazonPageFactory.getAmazonPageFactory.HomePageItemSearchTXT.sendKeys(searchitem);
	}
	
	public void clickSearchBTN() {
		AmazonPageFactory.getAmazonPageFactory.HomePageItemSearchBTN.click();
	}
	
	public void selectCustomerReviewRate(String crrate) throws InterruptedException {
		if(crrate == "4 Stars & Up") {
			WebDriverHelper.scrollDown(AmazonPageFactory.getAmazonPageFactory.CustomerReview);
			AmazonPageFactory.getAmazonPageFactory.CustomerReview.click();
			Thread.sleep(5000);
		}
	}
	
	public void selectLanguage(String language) throws InterruptedException {
		if(language == "English") {
			WebDriverHelper.scrollDown(AmazonPageFactory.getAmazonPageFactory.Language);
			AmazonPageFactory.getAmazonPageFactory.Language.click();
			Thread.sleep(5000);
		}
	}
	
	public void getProductName() {
		List<String> productNames = new ArrayList<>();
		
		for (int i = 0; i < AmazonPageFactory.getAmazonPageFactory.SearchResultsItemName.size(); i++) {
			productNames.add(AmazonPageFactory.getAmazonPageFactory.SearchResultsItemName.get(i).getText());
		}
		
		PropertyFileHandler.writeProperty("ProductName", productNames.get(1));
		System.out.println("ProductName:" +PropertyFileHandler.readProperty("ProductName"));
	}
	
	public void selectProduct(int itemno) {
		AmazonPageFactory.getAmazonPageFactory.SearchResultsItemName.get(itemno-1).click();
	}
	
	public String verifyProductName() {
		System.out.println("PrName:" +AmazonPageFactory.getAmazonPageFactory.DetailPageProductName.getText());
		return AmazonPageFactory.getAmazonPageFactory.DetailPageProductName.getText();
	}
	
	public void selectProductQuantity(int noitems) {
		AmazonPageFactory.getAmazonPageFactory.QuantityDD.click();
		AmazonPageFactory.getAmazonPageFactory.QuantityDDValues.get(noitems-1).click();
	}
	
	public void getProductUnitPrice() {
		String unitprice = AmazonPageFactory.getAmazonPageFactory.SelectedItemUnitPrice.getText();
		int startIndex = unitprice.indexOf("$");
		unitprice = unitprice.substring(startIndex+1);
		PropertyFileHandler.writeProperty("UnitPrice", unitprice);
	}
	
	public void clickAddtoCartBTN() {
		AmazonPageFactory.getAmazonPageFactory.AddToCartBTN.click();
	}
	
	public void clickGotoCartBTN() {
		AmazonPageFactory.getAmazonPageFactory.GoToCartBTN.click();
	}
	
	public String verifyProductNameInShoppingCart() {
		String Productname = AmazonPageFactory.getAmazonPageFactory.ShopingCartProductName.getText();
		
		return Productname;
	}
	
	public String verifyProductQuantity() {
		String quantity = AmazonPageFactory.getAmazonPageFactory.QuantitySelected.getText();
		int startIndex = quantity.indexOf("(");
		int endIndex = quantity.indexOf("item");
		quantity = quantity.substring(startIndex+1, endIndex-1);
		return quantity;
	}
	
	public Double verifyTotalPrice() {
		String temptotal = AmazonPageFactory.getAmazonPageFactory.TotalPrice.getText();
		int startIndex = temptotal.indexOf("$");
		temptotal = temptotal.substring(startIndex+1);
		Double total = Double.parseDouble(temptotal);
		return total;
	}
	
	public Double calculateTotalPrice(Double UnitPrice, int NoOfQuantities) {
		return UnitPrice*NoOfQuantities;
	}
	
	public void clickDelete() {
		AmazonPageFactory.getAmazonPageFactory.DeleteOption.click();
	}
	
	public Double verifySubTotalPrice() {
		String a = AmazonPageFactory.getAmazonPageFactory.TotalPrice.getText();
		int startIndex = a.indexOf("$");
		a = a.substring(startIndex+1);
		Double total = Double.parseDouble(a);
		return total;
	}

}
