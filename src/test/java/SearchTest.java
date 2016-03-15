import org.testng.Assert;
import org.testng.annotations.Test;

import framework.SeleniumDriver;
import pages.BasePage;
import pages.GoogleHomePage;

public class SearchTest extends BasePage {

	@Test
	public void testSearchByPhrase() {
		String searchPhrase = "Cheese!";
		String expectedPageTitle = "Cheese! - Пошук Google";
		String expectedPageTitlePartialText = "cheese";
		String actualPagetitleBeforeSearch;
		String actualPageTitleAfterSearch;

		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.goToHomePage();
		googleHomePage.searchByText(searchPhrase);

		actualPagetitleBeforeSearch = googleHomePage.getPageTitle();
		System.out.println("Page title before search is: " + actualPagetitleBeforeSearch);

		googleHomePage.waitUntilPageTitleStartsWithPartialText(expectedPageTitlePartialText);

		actualPageTitleAfterSearch = googleHomePage.getPageTitle();
		System.out.println("Page after search is: " + actualPageTitleAfterSearch);
		Assert.assertEquals(actualPageTitleAfterSearch, expectedPageTitle, "Actual page title is incorrect");

		SeleniumDriver.getInstance().quitSeleniumDriver();
	}
}
