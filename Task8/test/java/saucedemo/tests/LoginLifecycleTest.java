package saucedemo.tests;

import saucedemo.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class LoginLifecycleTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

        System.out.println("BeforeMethod: Navigate to Login Page");
    }

    @Test (priority = 1)
    public void validLoginTest()
    {
        System.out.println("Running Valid Login Test");

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test (priority = 2)
    public void invalidLoginTest()
    {
        System.out.println("Running Invalid Login Test");

        loginPage.login("wrong_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains(
        "Username and password do not match"));
    }

    @Test (priority = 3)
    public void lockedUserTest()
    {

        System.out.println("Running Locked User Test");

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains(
                        "Sorry, this user has been locked out"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(org.testng.ITestResult result) throws IOException {

        if (result.getStatus() == org.testng.ITestResult.FAILURE) {

            System.out.println("Test Failed: " + result.getName());

            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Files.copy(
                    screenshot.toPath(),
                    Paths.get("screenshots/" + result.getName() + ".png"),
                    StandardCopyOption.REPLACE_EXISTING
            );
        }

        else if (result.getStatus() == org.testng.ITestResult.SUCCESS)
        {

            System.out.println("Test Passed: " + result.getName());
        }

        else
        {
            System.out.println("Test Skipped: " + result.getName());
        }
    }
}
