package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import testbase.*;

import java.util.*;

public class EnterVehicleDataPage extends BaseTest {
    @FindBy(xpath = "//select[@id='make']")
    WebElement dropDown_make;

    @FindBy(xpath = "//select[@id='model']")
    WebElement dropDown_model;
    @FindBy(id = "cylindercapacity")
    WebElement txt_cylinderCapacity;
    @FindBy(xpath = "//input[@id='cylindercapacity']//following-sibling::span[@class='error']")
    WebElement error_cylinderCapacityTxt;
    @FindBy(id="engineperformance")
    WebElement txt_enginePerformance;
    @FindBy(xpath="//input[@id='dateofmanufacture']")
    WebElement date_manufacture;
    @FindBy(xpath = "//select[@id='numberofseatsmotorcycle']")
    WebElement dropDown_noOfSeats;
    @FindBy(id="listprice")
    WebElement txt_listPrice;
    @FindBy(id="annualmileage")
    WebElement txt_annualMileage;
    @FindBy(id="nextenterinsurantdata")
    WebElement button_next;

    public EnterVehicleDataPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterCylinderCapacity(String inputString) {
        txt_cylinderCapacity.sendKeys(inputString);
    }

    public String getCylindrCapacityErrorTxt() {
        return error_cylinderCapacityTxt.getText();
    }

    public List<String> getDropDownModel() {
        return cm.getDropDownOptionAsList(dropDown_model);
    }

    public void enterVehicleData(HashMap<String, String> testData) throws Exception {
        cm.selectDropdownOption(dropDown_make, testData.get("Vehicle_Make"));
        cm.selectDropdownOption(dropDown_model, testData.get("Vehicle_Model"));
        txt_cylinderCapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
        txt_enginePerformance.sendKeys(testData.get("Vehicle_Enging Performance"));
        date_manufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
        cm.selectDropdownOption(dropDown_noOfSeats, testData.get("Vehicle_No of Seats_motorcycle"));
        txt_listPrice.sendKeys(testData.get("Vehicle_List Price"));
        txt_annualMileage.sendKeys(testData.get("Vehicle_Annual Mileage"));

//        cm.selectDropdownOption(dropDown_make, "Honda");
//        cm.selectDropdownOption(dropDown_model, "Moped");
//        txt_cylinderCapacity.sendKeys("33");
//        txt_enginePerformance.sendKeys("12");
//        date_manufacture.sendKeys("07/01/2024");
//        cm.selectDropdownOption(dropDown_noOfSeats, "2");
//        txt_listPrice.sendKeys("500");
//        txt_annualMileage.sendKeys("123");
    }

    public void clickOnNextButton() {
        button_next.click();
    }


}


