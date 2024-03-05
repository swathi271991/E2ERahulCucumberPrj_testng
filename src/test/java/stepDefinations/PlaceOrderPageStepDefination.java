package stepDefinations;

import org.testng.Assert;
import PageObjects.PlaceOrderPage;
import Utils.TextContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderPageStepDefination {

	public TextContext testcontext;
	public PlaceOrderPage po;

	public PlaceOrderPageStepDefination(TextContext testcontext) {
		this.testcontext = testcontext;
		po = testcontext.pageobjects.getplaceOrderPageObject();
	}

	@When("user selects the country and clicks on Order button")
	public void user_selects_the_country_and_clicks_on_Order_button() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		po.selectFromDropDown(testcontext.testbase.prop.getProperty("country"));
		po.clickOncheckBx();
		po.clickonProceedBtn();
	}

	@Then("user successfully place the order")
	public void user_successfully_place_the_order() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String successmsg = po.getOrderSuccessMesg();
		if (successmsg.contains("Your order has been placed successfully ...!!!")) {

			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

}
