package testbase;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;
import pageobjects.*;
import utilities.*;

import java.io.*;
import java.util.concurrent.*;

public class BaseTest extends ObjectsRepository{
    public void initialteBrowser() throws IOException {
        String browser = Configuration.getPropertyValue("browser");
        String url = Configuration.getPropertyValue("url");

        switch (browser) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            case("safari"):
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @BeforeMethod
    protected void initiateTest() throws IOException {
        initialteBrowser();
        homePageObjects = new HomePageObjects();
        vehicleData = new EnterVehicleDataPage();
        insurantDataPage = new EnterInsurantDataPage();
        productDataPage = new EnterProductDataPage();
        priceOptionsPage = new SelectPriceOptionsPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
