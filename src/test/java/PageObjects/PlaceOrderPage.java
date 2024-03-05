package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlaceOrderPage {

	public WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//select")
	private WebElement selectDropdown;

	@FindBy(xpath = "//input[@class = 'chkAgree']")
	private WebElement checkboxAgree;

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement Proceedbtn;

	@FindBy(xpath = "//div[@class='wrapperThree']")
	private WebElement successPlacedOrder;

	public void selectFromDropDown(String countryname) {
		
		Select options = new Select(selectDropdown);
		options.selectByVisibleText(countryname);
	}

	public void clickOncheckBx() {
		checkboxAgree.click();
	}

	public void clickonProceedBtn() {
		Proceedbtn.click();
	}

	public String getOrderSuccessMesg() {
		return successPlacedOrder.getAttribute("innerText");
	}

}
