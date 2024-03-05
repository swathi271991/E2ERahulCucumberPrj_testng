package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public Landingpage lp;
	public OffersPage op;
	public CheckOutPage cp;
	public PlaceOrderPage po;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public Landingpage getLandingPageObject() {
		lp = new Landingpage(driver);
		return lp;
	}

	public OffersPage getOffersPageObject() {
		op = new OffersPage(driver);
		return op;
	}

	public CheckOutPage getCheckoutPageObject() {
		cp = new CheckOutPage(driver);
		return cp;
	}

	public PlaceOrderPage getplaceOrderPageObject() {
		po = new PlaceOrderPage(driver);
		return po;
	}

}
