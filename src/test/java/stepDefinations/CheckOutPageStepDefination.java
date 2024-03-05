package stepDefinations;

import org.testng.Assert;
import PageObjects.CheckOutPage;
import PageObjects.Landingpage;
import Utils.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutPageStepDefination {

	public TextContext textContext;
	public Landingpage lp;
	public CheckOutPage cp;

	public CheckOutPageStepDefination(TextContext textcontext) {
		
		this.textContext = textcontext;
		lp = textcontext.pageobjects.getLandingPageObject();
		cp = textcontext.pageobjects.getCheckoutPageObject();
	}

	@When("user increases the quantity of the product and clicks on Add to Cart")
	public void user_increases_the_quantity_of_the_product_and_clicks_on_add_to_cart() {

		for (int i = 0; i <= 3; i++) {
			lp.clickOnIncrementIcon();
		}
		
		lp.addToCart();
	}

	@And("user opens the cart and proceed to checkout")
	public void user_opens_the_cart_and_proceed_to_checkout() {

		lp.clickOnCartImg();
		lp.ProceedCheckOut();
	}

	@Then("user validates the product selected in landing page appears in checkout page")
	public void user_validates_the_product_selected_in_landing_page_appears_in_checkout_page() {

		if(cp.getproductname().trim().contains(textContext.searchedproductToIncrement))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	@And("user enters promocode in textfield")
	public void user_enters_promocode_in_textfield() {
		
		cp.getpromotextBox(textContext.testbase.prop.getProperty("promo"));
	}

	@And("user validates Apply button and Place Order buttons are displayed in checkout page")
	public void user_validates_apply_button_and_place_order_buttons_are_displayed_in_checkout_page() {

		cp.clickPromoBtn();
		
		Assert.assertEquals(cp.getpromoInfo().trim(), "Code applied ..!");
		cp.getPlaceOrder();
		
	}

}
