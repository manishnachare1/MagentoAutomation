package testcases;

import org.openqa.selenium.By;

//package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.CreateAccountPage;
import pages.LoginPage;
import utilities.ExtentManager;
import utilities.ScreenshotUtility;

public class AccountCreationTest extends BaseTest {

	@Test
	public void testCreateNewAccountAndLogin() {
		 System.out.println("Running test with page title: " + driver.getTitle());
		
		logger.info("Starting the valid create account and login test.");
		 // Create a test in Extent Reports
        test = ExtentManager.createTest("Valid Login Test");
        
		// Navigate to Create Account page
		driver.findElement(By.linkText("Create an Account")).click();

		test.log(Status.INFO, " Click on 'Create an Account' link");
		// Fill the form and create account
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		
		createAccountPage.enterFirstName("Manish");
		test.log(Status.INFO, " Entered First Name");
		createAccountPage.enterLastName("Test");
		test.log(Status.INFO, " Entered Last Name");
		String uniqueEmail = "manish.test" + System.currentTimeMillis() + "@test.com";
		createAccountPage.enterEmail(uniqueEmail);
		test.log(Status.INFO, " Entered EMail");
		createAccountPage.enterPassword("Test@1234");
		test.log(Status.INFO, " Entered Password");
		createAccountPage.confirmPassword("Test@1234");
		test.log(Status.INFO, " Entered Password again i 'Confirm Password field");
		createAccountPage.clickCreateAccount();
		test.log(Status.INFO, " Click on 'Create an Account' button");
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

		String actualWelcomeMessage = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']")).getText();
		Assert.assertTrue(actualWelcomeMessage.contains(expectedWelcomeMessage), "Login failed.");
		 logger.info("Login test passed.");
		 
		  
	}
	
	@AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        // Check if the test failed
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtility.captureScreenshot(driver, result.getName());
        }
        
     /* @AfterMethod
        public void tearDownSuite() {
            // Custom teardown logic
            super.tearDown(); // Ensures BaseTest's teardown is executed
        }*/
    }
}
