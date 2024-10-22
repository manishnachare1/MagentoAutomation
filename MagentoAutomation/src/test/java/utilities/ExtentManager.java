package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;// This is the reporter used to generate the HTML report
    private static ExtentTest test; // The main class that manages reporting.
    private static ExtentSparkReporter sparkReporter; // Represents each individual test case.

    // Initialize ExtentReports
    public static ExtentReports createInstance(String filePath) {
        sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setDocumentTitle("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Your Name"); // You can add more system info if needed

        return extent;
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

}
