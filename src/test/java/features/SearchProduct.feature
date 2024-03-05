Feature: Search and Place order for products

@Offers
Scenario Outline: validating searched product in home and offers page

Given user is on GreenCart Landing Page
When user searched with shortname <vegetable> and extracted actual name of the product
Then user searched for <vegetable> shortname in offers page
And user checks if product exists

Examples:
	|	vegetable	|
	|	Tom	|
	|	Pot	|
	|	straw	|

@Order
Scenario: validating add to cart and proceed to checkout and place order functionality

Given user is on GreenCart Landing Page
When user searched with shortname "Oni" and extract the actual name of the product
And user increases the quantity of the product and clicks on Add to Cart
And user opens the cart and proceed to checkout
Then user validates the product selected in landing page appears in checkout page
And user enters promocode in textfield
And user validates Apply button and Place Order buttons are displayed in checkout page
When user selects the country and clicks on Order button
Then user successfully place the order







