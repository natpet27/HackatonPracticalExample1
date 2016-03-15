package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {
private final String HOME_URL = "https://www.google.com";
	
	@FindBy (name="q")
	private WebElement searchTextField;
	
	private void enterTextIntoSearchTextField(String text) {
		enterTextIntoTextField(searchTextField, text);
	}
	
	public void goToHomePage() {
		goToPage(HOME_URL);
	}
	
	public void searchByText(String text) {
		enterTextIntoSearchTextField(text);
		searchTextField.submit();
	}
}
