package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Page elements
	private By emailField = By.id("email");
	private By passwordField = By.id("pass");
	private By signInButton = By.id("send2");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
}
