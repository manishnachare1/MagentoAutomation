package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {

	private WebDriver driver;

	// Page elements
	private By emailField = By.id("email");
	private By passwordField = By.id("pass");
	private By signInButton = By.id("send2");
	
	 private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions
	public void enterEmail(String email) {
		  logger.info("Entering username: " + email);
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		logger.info("Entering password: " + password);
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSignIn() {
		logger.info("Clicking SignIn Button.");
		driver.findElement(signInButton).click();
	}
}
