import framework.SeleniumDriver;
import pages.BasePage;
import pages.GoogleHomePage;

public class SearchTest extends BasePage {
	public static void main(String[] args) {
		
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.goToHomePage();
		googleHomePage.searchByText("Cheese!");

		System.out.println("Page title is: " + googleHomePage.getPageTitle());

		googleHomePage.waitUntilPageTitleStartsWithPartialText("cheese!");

		// np: There is no assert in this test. At this point asserting must be
		// done: do we receive expected page title
		System.out.println("Page title is: " + googleHomePage.getPageTitle());

		/*
		 * This will be done a lot of times, so separate method must be created
		 * for this But this doesn't guarantee that driver will quit if an
		 * exception occurs. So @AfterMethod annotaion must be use to be sure
		 * webBrowser will be closed after test failed
		 */

		SeleniumDriver.getInstance().quitSeleniumDriver();
	}

}
