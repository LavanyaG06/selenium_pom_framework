package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class CommonMethods {
    public void selectCheckBoxes(List<WebElement> elements, String options) {
        String[] optionsArray = options.split(",");

        for(String option : optionsArray) {
            for (WebElement element : elements) {
                if(option.equalsIgnoreCase(element.getText())) {
                    element.click();
                    break;
                }
            }
        }
    }

    public void selectRadioButtonOption(List<WebElement> elements, String gender) {
        for(WebElement element : elements) {
            if(element.getText().equalsIgnoreCase(gender)) {
                element.click();
                break;
            }
        }
    }

    public void selectDropdownOption(WebElement element, String option) throws Exception {
        Select select = new Select(element);
        try{
            select.selectByVisibleText(option);
        }catch(Exception e) {
            throw new Exception("Value is not present in dropdowm for this web element "+ element);
        }
    }

    public List<String> getDropDownOptionAsList(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> getOptions = new ArrayList<>();

        for(WebElement e : options) {
            getOptions.add(e.getText());
        }
        return getOptions;
    }
}
