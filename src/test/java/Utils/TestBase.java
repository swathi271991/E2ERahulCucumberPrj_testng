package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public TestBase testbase;
	public Properties prop;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fs);

		if (driver == null) {

			String browser_prop = prop.getProperty("browser");
			String browser_maven = System.getProperty("browser");

			String browser = (browser_maven == null) ? browser_prop : browser_maven;

			if (browser.equals("chrome")) {
				driver = new ChromeDriver(); // driver gets life
			}

			else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}

			else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			}

			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		return driver;
	}

}
