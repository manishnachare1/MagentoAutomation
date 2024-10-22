package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
	import utilities.TestDataProvider;
	import pages.LoginPage;
	import base.BaseTest;

	public class LoginTest extends BaseTest {

	    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	    public void testLogin(String username, String password) {
	    	driver.findElement(By.linkText("Sign In")).click();
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterEmail(username);
	        loginPage.enterPassword(password);
	        loginPage.clickSignIn();
	        
	        String expectedWelcomeMessage = "Home Page";
	        
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//String actualWelcomeMessage = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']")).getText();
			String Homepagetext = driver.findElement(By.xpath("//span[@class='base']")).getText();
			
			String HomepageTitleText= driver.getTitle();
			System.out.println(HomepageTitleText);
			Assert.assertTrue(HomepageTitleText.contains(expectedWelcomeMessage), "Login Passed.");
		
			 logger.info("Login test passed.");

	        // Assert login result
	    }

}
