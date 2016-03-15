import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
	public static void main(String[] args) {
		// np=natalia petriv
		/*
		 * np: 1) usually a test shouldn't know about webdriver or other library
		 * that 'comunicates with webbrowser'. It will be better if test works
		 * with pages of web-application and 'inside of these pages' (in their
		 * classes) webdriver will be used
		 * 
		 * 2) if there are a lot of tests, it will be hard to control a lot of
		 * instances of webdriver that will be created here and there (some
		 * collisions may appear). Will be good to use Singletone pattern - to
		 * control there is only one instance of webdriver created
		 */
		WebDriver driver = new FirefoxDriver();

		/*
		 * np: 1) not good to "talk to webdriver" in the test. What if the team
		 * decides to change library: there will be dozens of places to change
		 * library object had been used
		 * 
		 * 2) there will be a lot of places when you need to go to the pages.
		 * Better to move this action to separate method of the basePage class:
		 * goToPage (String url)
		 */
		driver.get("http://www.google.com");

		/*
		 * np: 1) if there are a lot of tests that test google search, this
		 * element will be used often. So there is a need to move it's locator
		 * to one place: so in case of change it will be changed in one place
		 * only.
		 * 
		 * 2) It will be more readable if it's name is not 'element', but
		 * searchTextField
		 */
		WebElement element = driver.findElement(By.name("q"));

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
		System.out.println("Page title is: " + driver.getTitle());

		/*
		 * np: wait for getPageTitleContains can be separate method in base
		 * class Another qa that will read this code doesn't need to know all
		 * the details of this method. He will better sees good name:
		 * waitForPageTitleToContain(String pasrtialText)
		 */

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		// np: There is no assert in this test. At this point asserting must be
		// done: do we receive expected page title
		System.out.println("Page title is: " + driver.getTitle());

		/*
		 * This will be done a lot of times, so separate method must be created
		 * for this But this doesn't guarantee that driver will quit if an
		 * exception occurs. So @AfterMethod annotaion must be use to be sure
		 * webBrowser will be closed after test failed
		 */

		driver.quit();
	}

}
