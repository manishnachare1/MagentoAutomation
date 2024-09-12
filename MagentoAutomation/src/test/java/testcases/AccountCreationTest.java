package testcases;

import org.openqa.selenium.By;

//package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateAccountPage;
import pages.LoginPage;
import utilities.ScreenshotUtility;

public class AccountCreationTest extends BaseTest {

	@Test
	public void testCreateNewAccountAndLogin() {
		
		  logger.info("Starting the valid login test.");
		// Navigate to Create Account page
		driver.findElement(By.linkText("Create an Account")).click();

		// Fill the form and create account
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		createAccountPage.enterFirstName("Manish");
		createAccountPage.enterLastName("Test");
		String uniqueEmail = "manish.test" + System.currentTimeMillis() + "@test.com";
		createAccountPage.enterEmail(uniqueEmail);
		createAccountPage.enterPassword("Test@1234");
		createAccountPage.confirmPassword("Test@1234");
		createAccountPage.clickCreateAccount();

		// Optional wait to ensure account is created and signed in
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Sign out
		driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		// Sign in again with the newly created account
		driver.findElement(By.linkText("Sign In")).click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(uniqueEmail);
		loginPage.enterPassword("Test@1234");
		loginPage.clickSignIn();

		// Validate successful login
		String expectedWelcomeMessage = "Welcome, Manish Test!";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String actualWelcomeMessage = driver
				.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']")).getText();
		Assert.assertTrue(actualWelcomeMessage.contains(expectedWelcomeMessage), "Login failed.");
		 logger.info("Login test passed.");
		 
		  
	}
	
	@AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        // Check if the test failed
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtility.captureScreenshot(driver, result.getName());
        }
    }
}
