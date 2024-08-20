package utilities;

import com.aventstack.extentreports.*;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.testng.*;
import testbase.*;

import java.io.*;
import java.text.*;
import java.time.*;

public class ListenersImplementation extends ObjectsRepository implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test case: "+result.getMethod().getMethodName()+" is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test case: "+result.getMethod().getMethodName()+" is failed.");
        extentTest.log(Status.FAIL, result.getThrowable());

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-SS");
        LocalDate date = LocalDate.now();
        String actualDate = format.format(date);

        String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/"+actualDate+".jpeg";
        File destinationFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            //extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
            extentTest.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
        }
       extentTest.addScreenCaptureFromPath(screenshotPath, "failed testcase screenshot");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportSetup.extentReportSetup();
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
