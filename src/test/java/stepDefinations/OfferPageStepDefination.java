package stepDefinations;

import org.testng.Assert;
import PageObjects.Landingpage;
import PageObjects.OffersPage;
import Utils.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OfferPageStepDefination {

	public String offerPageprd;
	public TextContext testContext;
	public OffersPage op;
	public Landingpage lp;
	

	public OfferPageStepDefination(TextContext testContext) {

		this.testContext = testContext;
		op = testContext.pageobjects.getOffersPageObject();	
		lp = testContext.pageobjects.getLandingPageObject();
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String vegname) {
		
		lp.getTopDealsLink().click();
		
		testContext.utils.switchTochildWindow();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		op.offerPage_SearchField(vegname);
		offerPageprd = op.offerPageprd().getText();

		System.out.println("Product searched in offers Page " + offerPageprd);
	}


	@And("user checks if product exists")
	public void m1() {
		
		if (testContext.productname.equals(offerPageprd)) {
			Assert.assertEquals(testContext.productname, offerPageprd);
			System.out.println("product exists in home and offer pages");
		} else {
			Assert.fail();
			System.out.println("product does not exists in home and offer pages");
		}
	}

}
