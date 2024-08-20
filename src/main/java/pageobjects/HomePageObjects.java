package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import testbase.*;

public class HomePageObjects extends BaseTest {
    @FindBy(xpath= "//div[@class='main-navigation']//a[@id='nav_automobile']")
    WebElement link_automobile;

    @FindBy(xpath= "//div[@class='main-navigation']//a[@id='nav_truck']")
    WebElement truck;

    @FindBy(xpath= "//div[@class='main-navigation']//a[@id='nav_motorcycle']")
    WebElement link_motorcycle;
    @FindBy(xpath= "//div[@class='main-navigation']//a[@id='nav_camper']")
    WebElement link_camper;

    public HomePageObjects() {
        PageFactory.initElements(driver, this);
    }

    public void clickActionOnMotorCycle() {
        link_motorcycle.click();
    }

}
