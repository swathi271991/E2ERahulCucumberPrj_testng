package Utils;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

	public WebDriver driver;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchTochildWindow() {

			Set<String> win_handles = driver.getWindowHandles();
			Iterator<String> itr = win_handles.iterator();
			String parent_window = itr.next();
			String child_window = itr.next();
			driver.switchTo().window(child_window);
		}

}
