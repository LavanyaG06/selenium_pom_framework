package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import testbase.*;

import java.util.*;

public class EnterInsurantDataPage extends BaseTest {

    @FindBy(id="firstname")
    WebElement txt_firstname;

    @FindBy(id="lastname")
    WebElement txt_lastname;

    @FindBy(id="birthdate")
    WebElement date_dob;

    @FindBy(xpath="//input[@name='Gender']/parent::label")
    List<WebElement> radio_gender;

    @FindBy(id="streetaddress")
    WebElement txt_streetaddress;

    @FindBy(xpath = "//select[@id='country']")
    WebElement dropdown_country;

    @FindBy(id="zipcode")
    WebElement txt_zipcode;

    @FindBy(id="city")
    WebElement txt_city;

    @FindBy(xpath="//select[@id='occupation']")
    WebElement dropdown_occupation;

    @FindBy(xpath="//input[@name='Hobbies']/parent::label")
    List<WebElement> checkbox_hobbies;

    @FindBy(xpath="")
    WebElement image_picture;

    @FindBy(id="nextenterproductdata")
    WebElement button_next;

    public EnterInsurantDataPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterTextInsuranceData(HashMap<String, String> testData) throws Exception {
        txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
        txt_lastname.sendKeys(testData.get("Insurant_LastName"));
        date_dob.sendKeys(testData.get("Insurant_birthdate"));
        cm.selectRadioButtonOption(radio_gender, testData.get("Insurant_gender"));
//        txt_streetaddress.sendKeys(testData.get("Insurant_FirstName"));
        cm.selectDropdownOption(dropdown_country, testData.get("Insurant_country"));
        txt_zipcode.sendKeys(testData.get("Insurant_zipcode"));
        txt_city.sendKeys(testData.get("Insurant_FirstName"));
        cm.selectDropdownOption(dropdown_occupation, testData.get("Insurant_occupation"));
        cm.selectCheckBoxes(checkbox_hobbies, testData.get("Insurant_Hobby"));


//        txt_firstname.sendKeys("test");
//        txt_lastname.sendKeys("retest");
//        date_dob.sendKeys("12/12/2000");
//        cm.selectRadioButtonOption(radio_gender, "Female");
//        txt_streetaddress.sendKeys("test123 st");
//        cm.selectDropdownOption(dropdown_country, "United States");
//        txt_zipcode.sendKeys("12345");
//        txt_city.sendKeys("NewYork");
//        cm.selectDropdownOption(dropdown_occupation, "Selfemployed");
//        cm.selectCheckBoxes(checkbox_hobbies, "Speeding,Other");
    }

    public void clickOnNextButton() {
        button_next.click();
    }
}
