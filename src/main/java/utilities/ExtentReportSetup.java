package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.*;

import java.text.*;
import java.util.*;

public class ExtentReportSetup {

    public static ExtentReports extentReportSetup() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-SS");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportsPath = System.getProperty("user.dir") + "/Reports/ExtentReport_"+actualDate+".html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportsPath);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("DocumentTitle");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("ReportName");
        return extentReports;
    }
}
