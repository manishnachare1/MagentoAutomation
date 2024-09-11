package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	  // Create a logger instance
    public static Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	public void setUp(ITestContext context) {
		// Set up WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 context.setAttribute("driver", driver);
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
