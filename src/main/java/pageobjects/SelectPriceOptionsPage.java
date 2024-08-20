package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import testbase.*;

public class SelectPriceOptionsPage extends BaseTest {
    @FindBy(id="nextsendquote")
    WebElement  button_next;

    public SelectPriceOptionsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPriceForSelectedOption(String plan) {
        String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
        return driver.findElement((By.xpath(dataXpath))).getText();
    }

    public void clickSelectOption(String plan) {
        String clickXpath = "//input[@name='Select Option' and  @value='"+plan+"']/parent::label";
        driver.findElement(By.xpath(clickXpath)).click();
    }

    public void  clickOnNextButton() {
        button_next.click();
    }

}
