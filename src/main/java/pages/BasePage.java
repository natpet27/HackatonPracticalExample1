package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.SeleniumDriver;

public class BasePage {
	
	private SeleniumDriver seleniumWebDriver;
	
	public BasePage() {
		seleniumWebDriver = SeleniumDriver.getInstance();
		PageFactory.initElements(seleniumWebDriver.getWebDriver(), this);
	}
	
	public String getPageTitle() {
		return seleniumWebDriver.getWebDriver().getTitle();
	}
	
	public void goToPage(String url) {
		SeleniumDriver.getInstance().getWebDriver().get(url);
	}
	
	public void waitUntilPageTitleStartsWithPartialText(final String partialText) {
		(new WebDriverWait(SeleniumDriver.getInstance().getWebDriver(), SeleniumDriver.getInstance().getTimeOutTime()))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().toLowerCase().startsWith(partialText);
					}
				});
	}
}
