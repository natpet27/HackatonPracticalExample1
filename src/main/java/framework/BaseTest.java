package framework;

import org.testng.annotations.AfterMethod;

import pages.BasePage;

public class BaseTest extends BasePage {
	
	@AfterMethod
	public void tearDown() {
		if (SeleniumDriver.getInstance().getWebDriver() != null) {
			SeleniumDriver.getInstance()
					.quitSeleniumDriver();
		}
	}

}
