package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager;
import utilities.ScreenshotUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public ExtentReports extent;
	public ExtentTest test;
	
	  // Create a logger instance
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    
    @BeforeSuite
    public void setupSuite() {
        // Initialize ExtentReports with the report file path
        extent = ExtentManager.createInstance(System.getProperty("user.dir") + "/test-output/Test Reports/ExtentReport.html");
    }

	@BeforeMethod
	public void setUp(ITestContext context) {
		// Set up WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 context.setAttribute("driver", driver);
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
 /* // code for Headless mode
	@Parameters({"browser", "headless"})  // Retrieve parameters from testng.xml
    public void setup(String browser, String headless) {
        boolean isHeadless = Boolean.parseBoolean(headless);  // Convert headless to boolean

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless");  // Enable headless mode
              //  options.addArguments("window-size=1920,1080");  // Optional: Set window size
            }
          //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
           // driver.manage().window().maximize();

        } 
        
        /*else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.setHeadless(true);  // Enable headless mode
            }
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver(options);
        }
      

        // Navigate to the desired URL
        driver.get("https://magento.softwaretestingboard.com/");
          
    }*/
	
	//@AfterMethod
	/*public void getResult(ITestResult result) 
	{
        // Log the result of each test case in Extent Reports
        if (result.getStatus() == ITestResult.FAILURE) {
        	  String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }
    }*/
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@AfterSuite
    public void tearDownSuite() {
        // Close ExtentReports and generate the report
        extent.flush();
    }

}
