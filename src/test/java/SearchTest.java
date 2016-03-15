import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.SeleniumDriver;

public class SearchTest {
	public static void main(String[] args) {
		// np=natalia petriv
		/*
		 * 2) there will be a lot of places when you need to go to the pages.
		 * Better to move this action to separate method of the basePage class:
		 * goToPage (String url)
		 */
		SeleniumDriver.getInstance().getWebDriver().get("http://www.google.com");

		/*
		 * np: 1) if there are a lot of tests that test google search, this
		 * element will be used often. So there is a need to move it's locator
		 * to one place: so in case of change it will be changed in one place
		 * only.
		 * 
		 * 2) It will be more readable if it's name is not 'element', but
		 * searchTextField
		 */
		WebElement element = SeleniumDriver.getInstance().getWebDriver().findElement(By.name("q"));

		/*
		 * np: 1) Action below can be moved to separate method
		 * enterTextIntoSearchTextField/setTextIntoSearchTextField(String
		 * searchText) as it will be used again in other tests
		 */
		element.sendKeys("Cheese!");

		/*
		 * np: all those three actions can be combined together in one method
		 * searchByText(String searchText) that will do 3 steps: click on
		 * textField, clear it, enter searchTextField and submits itTest will be
		 * more aesy to understand if it contains not 100 steps, but methods
		 * that are more close to test steps: login, makeOrder, addToBasket etc
		 */
		element.submit();

		// np: getPageTitle can be method in BasePage class as probably it will
		// be used again
		System.out.println("Page title is: " + SeleniumDriver.getInstance().getWebDriver().getTitle());

		/*
		 * np: wait for getPageTitleContains can be separate method in base
		 * class Another qa that will read this code doesn't need to know all
		 * the details of this method. He will better sees good name:
		 * waitForPageTitleToContain(String pasrtialText)
		 */

		(new WebDriverWait(SeleniumDriver.getInstance().getWebDriver(), 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		// np: There is no assert in this test. At this point asserting must be
		// done: do we receive expected page title
		System.out.println("Page title is: " + SeleniumDriver.getInstance().getWebDriver().getTitle());

		/*
		 * This will be done a lot of times, so separate method must be created
		 * for this But this doesn't guarantee that driver will quit if an
		 * exception occurs. So @AfterMethod annotaion must be use to be sure
		 * webBrowser will be closed after test failed
		 */

		SeleniumDriver.getInstance().quitSeleniumDriver();
	}

}
