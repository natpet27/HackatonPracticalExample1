package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {
	private static SeleniumDriver seleniumDriver;
	private WebDriver webDriver;
	private final int timeOutTimeInSeconds = 30;
	
	private SeleniumDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public static SeleniumDriver getInstance() {
		if(seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver(new FirefoxDriver());
		}
		return seleniumDriver;
	}
	
	public int getTimeOutTime() {
		return timeOutTimeInSeconds;
	}
	
	public void quitSeleniumDriver() {
		getInstance().getWebDriver().quit();
	}
}
