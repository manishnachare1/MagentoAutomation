package listeners;


import utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    // Assuming WebDriver is being passed through the test context
    WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot on test failure
        driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
        Reporter.log("Screenshot captured for test case: " + result.getName() + " Screenshot path: " + screenshotPath);
    }

    @Override
    public void onTestStart(ITestResult result) { }
    @Override
    public void onTestSuccess(ITestResult result) { }
    @Override
    public void onTestSkipped(ITestResult result) { }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    @Override
    public void onStart(ITestContext context) { }
    @Override
    public void onFinish(ITestContext context) { }
}
