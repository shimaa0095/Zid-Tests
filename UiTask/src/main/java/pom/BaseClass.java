package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	static WebDriver driver;
	public void setUpChromeDriver(String url) {
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get(url);
	}


	public static WebDriver getWebDriver() {
		return driver;
	}


}
