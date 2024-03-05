package stepDefinations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Utils.TextContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	public TextContext textContext;

	public Hooks(TextContext textContext) {
		this.textContext = textContext;
	}

	@After
	public void tearDown() throws IOException {
		textContext.testbase.WebDriverManager().quit();

	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = textContext.testbase.WebDriverManager();
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] filesrc = FileUtils.readFileToByteArray(src);
			scenario.attach(filesrc, "image/png", "image");
		}
	}

}
