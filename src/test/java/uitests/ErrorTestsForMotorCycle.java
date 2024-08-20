package uitests;

import com.aventstack.extentreports.*;
import org.testng.*;
import org.testng.annotations.*;
import testbase.*;

import java.util.*;

public class ErrorTestsForMotorCycle extends BaseTest {

    @Test(enabled = false)
    public void errorValidationForInputs() {
        homePageObjects.clickActionOnMotorCycle();
        vehicleData.enterCylinderCapacity("23234");
        extentTest.log(Status.PASS, "Cylinder capacity is filled with data:23234");
        String actual = vehicleData.getCylindrCapacityErrorTxt();
        String expected = "Must be a number between 1 and 2000";

        Assert.assertEquals(actual, expected, "Error message is not excepted");
    }

    @Test(enabled = false)
    public void errorValidationForInputs1() {
        homePageObjects.clickActionOnMotorCycle();
        vehicleData.enterCylinderCapacity("23234");
        extentTest.log(Status.PASS, "Cylinder capacity is filled with data:23234");
        String actual = vehicleData.getCylindrCapacityErrorTxt();
        String expected = "Must be a number between 1 and 3000";

        Assert.assertEquals(actual, expected, "Error message is not excepted");
    }

    @Test
    public void validateVehicleModel() {
        homePageObjects.clickActionOnMotorCycle();
        List<String> vehicalModels = vehicleData.getDropDownModel();
        extentTest.log(Status.INFO, "Actual contents for model: " +vehicalModels);
        List<String> expectedModels = Arrays.asList("– please select –","Scooter", "Three-Wheeler", "Mopd", "Motorcycle");
        extentTest.log(Status.INFO, "Excepted contents for model: " +expectedModels);

        Assert.assertEquals(vehicalModels, expectedModels, "models should be mathched");
    }
}
