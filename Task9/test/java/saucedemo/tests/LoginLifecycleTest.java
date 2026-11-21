
package saucedemo.tests;

import saucedemo.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLifecycleTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void validLoginTest() {

        System.out.println("Running Valid Login Test");

        loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Valid login should navigate to inventory page"
        );
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        System.out.println("Running Invalid Login Test");

        loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_password");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Username and password do not match"
                ),
                "Expected error message was not displayed"
        );
    }

    @Test(priority = 3)
    public void lockedUserTest() {

        System.out.println("Running Locked User Test");

        loginPage = new LoginPage(driver);

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(
                        "Sorry, this user has been locked out"
                ),
                "Locked user error message was not displayed"
        );
    }
}
