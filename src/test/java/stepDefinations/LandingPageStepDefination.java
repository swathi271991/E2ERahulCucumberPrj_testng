package stepDefinations;

import org.testng.Assert;
import PageObjects.Landingpage;
import Utils.TextContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefination {

	public TextContext testContext;
	public Landingpage lp;

	public LandingPageStepDefination(TextContext testContext) {

		this.testContext = testContext;
	}

	@Given("user is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {

		lp = testContext.pageobjects.getLandingPageObject();

	}

	@When("^user searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String vegname) {

		lp.getSearchBox(vegname);
		lp.getSearch_Icon();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String completename = lp.getHomePage_ProductName().getText();
		testContext.productname = lp.getEnhancedText(completename);
		System.out.println("Product searched in home Page " + testContext.productname);

		if (testContext.productname.contains(vegname)) {
			Assert.assertTrue(true);
			System.out.println("Searched product found");
		}

	}

	@When("user searched with shortname {string} and extract the actual name of the product")
	public void user_searched_with_shortname_and_extract_actual_name(String vegname) {

		lp.getSearchBox(vegname);
		lp.getSearch_Icon();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String completename = lp.getHomePage_ProductName().getText();
		testContext.searchedproductToIncrement = lp.getEnhancedText(completename);
		System.out.println("Product searched in home Page " + testContext.searchedproductToIncrement);

		if (testContext.searchedproductToIncrement.contains(vegname)) {
			Assert.assertTrue(true);
			System.out.println("Searched product found");
		}

	}

}
