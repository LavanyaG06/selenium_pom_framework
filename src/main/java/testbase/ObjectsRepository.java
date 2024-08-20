package testbase;

import com.aventstack.extentreports.*;
import org.openqa.selenium.*;
import pageobjects.*;
import utilities.*;

public class ObjectsRepository {
    public static WebDriver driver;
    public HomePageObjects homePageObjects;
    public EnterVehicleDataPage vehicleData;
    public EnterInsurantDataPage insurantDataPage;
    public SelectPriceOptionsPage priceOptionsPage;
    public EnterProductDataPage productDataPage;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public CommonMethods cm = new CommonMethods();
}
