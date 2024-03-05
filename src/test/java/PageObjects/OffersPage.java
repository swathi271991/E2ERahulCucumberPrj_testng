package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {

	WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id ='search-field']")
	private WebElement offerPage_SearchField;

	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[1]")
	private WebElement offerPageprd;

	public void offerPage_SearchField(String name) {
		
		offerPage_SearchField.sendKeys(name);;
	}

	public WebElement offerPageprd() {
		return offerPageprd;
	}

}
