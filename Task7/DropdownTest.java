package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest() {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate dropdown
        WebElement dropdownElement =driver.findElement(By.id("dropdown"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Get all options
        List<WebElement> options =dropdown.getOptions();

        // Store option texts
        List<String> optionTexts = new ArrayList<>();

        for (WebElement option : options)
        {

            optionTexts.add(option.getText());

        }

        // Print all options
        System.out.println("Dropdown Options:");

        for (String text : optionTexts)
        {

            System.out.println(text);

        }

        // Select Option 1
        dropdown.selectByVisibleText("Option 1");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption().getText(),
                "Option 1"
        );

        // Select Option 2
        dropdown.selectByVisibleText("Option 2");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption().getText(),
                "Option 2"
        );

        // Verify no empty options
        for (String text : optionTexts)
        {

            Assert.assertFalse(
                    text.trim().isEmpty(),
                    "Option text is empty"
            );

        }

        // Verify options count
        Assert.assertEquals(options.size(), 3);

    }
}
