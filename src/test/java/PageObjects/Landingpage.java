package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	WebDriver driver;

	public Landingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement search_icon;

	@FindBy(xpath = "//h4[@class='product-name']")
	private WebElement HomePage_product_name;

	@FindBy(xpath = "//a[@class='increment']")
	private WebElement increment_icon;

	@FindBy(xpath = "//a[text()='Top Deals']")
	private WebElement HomePage_TopDealsLink;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement AddToCart_Landingpage;

	@FindBy(xpath = "//img[@alt='Cart']")
	private WebElement cartImg;

	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	private WebElement Proceed_checkOut;

	public WebElement getTopDealsLink() {
		return HomePage_TopDealsLink;
	}

	public void getSearchBox(String vegname) {
		searchBox.sendKeys(vegname);
	}

	public void getSearch_Icon() {
		search_icon.click();
	}

	public WebElement getHomePage_ProductName() {
		return HomePage_product_name;
	}

	public String getEnhancedText(String completename) {
		String pnames[] = completename.split(" -");
		return pnames[0].trim();
	}

	public void clickOnIncrementIcon() {
		increment_icon.click();
	}

	public void addToCart() {
		AddToCart_Landingpage.click();

	}

	public void clickOnCartImg() {
		cartImg.click();
	}

	public void ProceedCheckOut() {
		Proceed_checkOut.click();
	}

}
