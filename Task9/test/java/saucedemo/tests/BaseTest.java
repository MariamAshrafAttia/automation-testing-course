
package saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BaseTest {

    protected WebDriver driver;

    private static final String BASE_URL =
            "https://www.saucedemo.com/";

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("===== Test Suite Started =====");
    }

    @BeforeClass
    public void launchBrowser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        System.out.println("Browser Launched");
    }

    @BeforeMethod
    public void navigateToApplication() {

        driver.get(BASE_URL);

        System.out.println("Navigated to SauceDemo");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Test Failed: " + result.getName());

            takeScreenshot(result.getName());

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            System.out.println("Test Passed: " + result.getName());

        } else {

            System.out.println("Test Skipped: " + result.getName());
        }
    }

    private void takeScreenshot(String testName) {

        try {

            File screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            Path folder = Paths.get("src", "screenshots");

            Files.createDirectories(folder);

            Path destination =
                    folder.resolve(testName + ".png");

            Files.copy(
                    screenshot.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Screenshot saved: " + destination);

        } catch (Exception e) {

            System.out.println("Screenshot Error: " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser Closed");
    }
}
