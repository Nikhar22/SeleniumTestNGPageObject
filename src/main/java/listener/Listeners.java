package listener;

import Reporting.ExtentReporterNG;
import base.DriverBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Utils;


public class Listeners extends Utils implements ITestListener {
//    WebDriver driver;
ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    String testMethodName;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        testMethodName = result.getMethod().getMethodName();
        test = extent.createTest(testMethodName);
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed !");
        extentTest.get().pass(testMethodName+ " >>>>>> Passed");
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            extentTest.get().addScreenCaptureFromPath(getScreenshotForPassed(testMethodName, driver), testMethodName);
        } catch (Exception e) {
            System.out.println("Unable to take Screenshot.");
            e.printStackTrace();
        }


    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test has been failed");


        extentTest.get().fail(result.getThrowable());

//        WebDriver driver = null;
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), testMethodName);
        } catch (Exception e) {
            System.out.println("Unable to take Screenshot.");
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }

}
