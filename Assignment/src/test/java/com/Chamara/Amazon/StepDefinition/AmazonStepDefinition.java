package com.Chamara.Amazon.StepDefinition;

import com.Chamara.Amazon.PageObjects.AmazonPO;
import com.Chamara.Amazon.Utility.PropertyFileHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AmazonStepDefinition {

	@Given("I open the environment as {string}")
	public void i_open_the_environment_as(String url) throws InterruptedException {
		AmazonPO.getAmazonPO().a(PropertyFileHandler.readProperty(url));
	}

	@Then("I verify the Home page logo")
	public void i_verify_the_home_page_logo() {
		Assert.assertTrue(AmazonPO.getAmazonPO().verifyHomepageLogo());
	}

	@Then("I verify the Page title as {string}")
	public void i_verify_the_page_title_as(String pageTitle) {
		Assert.assertEquals(PropertyFileHandler.readProperty(pageTitle), AmazonPO.getAmazonPO().verifyPageTitle());
	}

	@When("I select {string} option in the list")
	public void i_select_option_in_the_list(String dpvalue) {
		AmazonPO.getAmazonPO().selectDDValue(dpvalue);
	}

	@When("I enter {string} as search key")
	public void i_enter_as_search_key(String searchitem) {
		AmazonPO.getAmazonPO().enterValue(searchitem);
	}

	@When("I click search button")
	public void i_click_search_button() {
		AmazonPO.getAmazonPO().clickSearchBTN();
	}

	@When("I select customer reviews as {string}")
	public void i_select_customer_reviews_as(String crrate) throws InterruptedException {
		AmazonPO.getAmazonPO().selectCustomerReviewRate(crrate);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) throws InterruptedException {
		AmazonPO.getAmazonPO().selectLanguage(language);
	}

	@Then("I get the second item name")
	public void i_get_the_second_item_name() {
		AmazonPO.getAmazonPO().getProductName();
	}

	@When("I select {string} item in the list")
	public void i_select_item_in_the_list(String itemno) {
		AmazonPO.getAmazonPO().selectProduct(Integer.parseInt(itemno));
	}

	@When("I get the Unit price as {string} in Product Detail page")
	public void i_get_the_unit_price_as_in_product_detail_page(String string) {
		AmazonPO.getAmazonPO().getProductUnitPrice();
	}

	@Then("I verify the Product Name as {string} in Product Detail page")
	public void i_verify_the_product_name_as_in_product_detail_page(String productName) {
		Assert.assertEquals(PropertyFileHandler.readProperty(productName), AmazonPO.getAmazonPO().verifyProductName());
	}

	@When("I set quantity as {string}")
	public void i_set_quantity_as(String noitems) {
		AmazonPO.getAmazonPO().selectProductQuantity(Integer.parseInt(PropertyFileHandler.readProperty(noitems)));
	}

	@When("I click add to cart button")
	public void i_click_add_to_cart_button() {
		AmazonPO.getAmazonPO().clickAddtoCartBTN();
	}

	@When("I click Go to Cart button")
	public void i_click_go_to_cart_button() {
		AmazonPO.getAmazonPO().clickGotoCartBTN();
	}

	@Then("I verify cart item name as {string}")
	public void i_verify_cart_item_name_as(String productName) {
		Assert.assertEquals(PropertyFileHandler.readProperty(productName),
				AmazonPO.getAmazonPO().verifyProductNameInShoppingCart());
	}

	@Then("I verify cart item quantity as {string}")
	public void i_verify_cart_item_quantity_as(String quantity) {
		Assert.assertEquals(PropertyFileHandler.readProperty(quantity), AmazonPO.getAmazonPO().verifyProductQuantity());
	}

	@Then("I verify cart item total price")
	public void i_verify_cart_item_total_price() {
		Assert.assertEquals(
				AmazonPO.getAmazonPO().calculateTotalPrice(
						Double.parseDouble(PropertyFileHandler.readProperty("UnitPrice")),
						Integer.parseInt(PropertyFileHandler.readProperty("NoOfQuantities"))),
				AmazonPO.getAmazonPO().verifyTotalPrice());
	}

	@When("I click delete item")
	public void i_click_delete_item() {
		AmazonPO.getAmazonPO().clickDelete();
	}

	@Then("I verify sub total as {string}")
	public void i_verify_sub_total_as(String SubTotal) {
		//AmazonPO.getAmazonPO().verifySubTotalPrice();
		Assert.assertEquals(Double.parseDouble(SubTotal), AmazonPO.getAmazonPO().verifySubTotalPrice());
	}

}
