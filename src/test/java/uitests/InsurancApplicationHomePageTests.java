package uitests;

import org.testng.annotations.*;
import testbase.*;
import utilities.*;

import java.io.*;
import java.util.*;

public class InsurancApplicationHomePageTests extends BaseTest {
    ExcelOperations excel = new ExcelOperations();

    @DataProvider(name = "motorVehicleTestData")
    public Object[][] motorVehicleDataProvider() throws IOException {
        Object[][] object = new Object[excel.getRowCount()][1];
        for(int i=1; i<=excel.getRowCount(); i++) {
            HashMap<String, String> testMap = excel.readExceldata(i);
            object[i-1][0] = testMap;
        }
        return object;
    }

    @Test(enabled=false)
    public void navigationBarTests() throws Exception {
//        homePageObjects.clickActionOnMotorCycle();
//        vehicleData.enterVehicleData();
//        vehicleData.clickOnNextButton();
//        insurantDataPage.enterTextInsuranceData();;
//        insurantDataPage.clickOnNextButton();
//        productDataPage.enterTextProductData();
//        productDataPage.clickOnNextButton();
    }

    @Test(dataProvider = "motorVehicleTestData")
    public void motorCycleInsuranceQuoteValidation(Object obj) throws Exception {
        HashMap<String, String> testData = (HashMap<String, String>) obj;
        homePageObjects.clickActionOnMotorCycle();
        vehicleData.enterVehicleData(testData);
        vehicleData.clickOnNextButton();
        insurantDataPage.enterTextInsuranceData(testData);;
        insurantDataPage.clickOnNextButton();
        productDataPage.enterTextProductData(testData);
        productDataPage.clickOnNextButton();
        String price = priceOptionsPage.getPriceForSelectedOption("Silver");

        priceOptionsPage.clickSelectOption("Silver");
        priceOptionsPage.clickOnNextButton();

    }

}
