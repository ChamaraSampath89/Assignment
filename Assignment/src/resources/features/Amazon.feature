Feature: Verify that the Amazon web site is working fine 

@Amazon_001 
Scenario: Verify that the user able to select product from a filtered list 
	Given I open the environment as "Amazon_url" 
	Then I verify the Home page logo
	And I verify the Page title as "HomePageTitle"
	And I select "Books" option in the list
	And I enter "Automation" as search key
	And I click search button
	And I select customer reviews as "4 Stars & Up"
	And I select language as "English"
	And I get the second item name
	And I select "2" item in the list
	When I get the Unit price as "UnitPrice" in Product Detail page
	Then I verify the Product Name as "ProductName" in Product Detail page
	When I set quantity as "NoOfQuantities"
	And I click add to cart button
	And I click Go to Cart button
	And I verify cart item name as "ProductName"
	And I verify cart item quantity as "NoOfQuantities"
	And I verify cart item total price
	When I click delete item
	Then I verify sub total as "0.0"
	