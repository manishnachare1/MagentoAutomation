package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
	private WebDriver driver;

	// Page elements
	private By firstNameField = By.id("firstname");
	private By lastNameField = By.id("lastname");
	private By emailField = By.id("email_address");
	private By passwordField = By.id("password");
	private By confirmPasswordField = By.id("password-confirmation");
	private By createAccountButton = By.cssSelector("button[title='Create an Account']");

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void confirmPassword(String password) {
		driver.findElement(confirmPasswordField).sendKeys(password);
	}

	public void clickCreateAccount() {
		driver.findElement(createAccountButton).click();
	}

}
