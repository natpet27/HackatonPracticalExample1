import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.SeleniumDriver;
import pages.BasePage;

public class SearchTest extends BasePage {
	public static void main(String[] args) {
		
		BasePage basePage = new BasePage();
		basePage.goToPage("http://www.google.com");

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

		System.out.println("Page title is: " + basePage.getPageTitle());

		basePage.waitUntilPageTitleStartsWithPartialText("cheese!");

		// np: There is no assert in this test. At this point asserting must be
		// done: do we receive expected page title
		System.out.println("Page title is: " + basePage.getPageTitle());

		/*
		 * This will be done a lot of times, so separate method must be created
		 * for this But this doesn't guarantee that driver will quit if an
		 * exception occurs. So @AfterMethod annotaion must be use to be sure
		 * webBrowser will be closed after test failed
		 */

		SeleniumDriver.getInstance().quitSeleniumDriver();
	}

}
