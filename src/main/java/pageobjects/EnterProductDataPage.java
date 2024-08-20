package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import testbase.*;

import java.util.*;

public class EnterProductDataPage extends BaseTest {

    @FindBy(id="startdate")
    WebElement date_startdate;

    @FindBy(xpath="//select[@id='insurancesum']")
    WebElement dropdown_insurancesum;

    @FindBy(xpath="//select[@id='damageinsurance']")
    WebElement dropdown_damageinsurance;

    @FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
    List<WebElement> checkbox_optionalproducts;

    @FindBy(id="nextselectpriceoption")
    WebElement button_next;

    public EnterProductDataPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterTextProductData(HashMap<String, String> testMap) throws Exception {

        date_startdate.sendKeys(testMap.get("Product_startdate"));
        cm.selectDropdownOption(dropdown_insurancesum, testMap.get("Product_insurancesum"));
        cm.selectDropdownOption(dropdown_damageinsurance, testMap.get("Product_damageinsurance"));
        cm.selectCheckBoxes(checkbox_optionalproducts, testMap.get("Product_OptionalProducts"));

//        date_startdate.sendKeys("08/01/2024");
//        cm.selectDropdownOption(dropdown_insurancesum, "5.000.000,00");
//        cm.selectDropdownOption(dropdown_damageinsurance, "Full Coverage");
//        cm.selectCheckBoxes(checkbox_optionalproducts, "Euro Protection");
    }

    public void clickOnNextButton() {
        button_next.click();
    }
}
