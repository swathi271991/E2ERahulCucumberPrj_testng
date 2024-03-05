package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {

	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='product-name']")
	private WebElement prodname_checkoutpage;

	@FindBy(xpath = "//input[@class='promoCode']")
	private WebElement promocode_textBox;

	@FindBy(xpath = "//button[@class='promoBtn']")
	private WebElement promoBtn;

	@FindBy(xpath = "//span[@class='promoInfo']")
	private WebElement promoinfo;

	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElement PlaceOrder;

	public String getproductname() {
		return prodname_checkoutpage.getText();
	}

	public void getpromotextBox(String text) {
		promocode_textBox.sendKeys(text);
	}

	public void clickPromoBtn() {
		promoBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(promoinfo));
	}

	public String getpromoInfo() {
		return promoinfo.getText();
	}

	public void getPlaceOrder() {
		PlaceOrder.click();
	}

}
