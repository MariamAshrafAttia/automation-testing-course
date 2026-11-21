
package saucedemo.tests;

import saucedemo.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProviderTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

        System.out.println("Opened Login Page");
    }

    @DataProvider(name = "loginScenarios")
    public Object[][] loginData() {

        return new Object[][]
        {
            {"standard_user", "secret_sauce", true,"", "Valid Login"},

            {"locked_out_user", "secret_sauce", false,"locked out", "Locked User"},

            {"wrong_user", "secret_sauce", false,"Username and password do not match",
                    "Invalid Username"},

            {"standard_user", "wrong_password", false,"Username and password do not match",
                    "Invalid Password"},

            {"", "secret_sauce", false,"Username is required", "Empty Username"},

            {"standard_user", "", false,"Password is required", "Empty Password"}
        };
    }

    @Test(  dataProvider = "loginScenarios",
            description = "Verify login with different credentials"
    )
    public void loginTest(
            String username,
            String password,
            boolean expectedLogin,
            String expectedMessage,
            String scenarioDescription) {

        System.out.println("Running: " + scenarioDescription);

        loginPage.login(username, password);

        if (expectedLogin) {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("inventory"),
                    scenarioDescription + " - Login should succeed"
            );

        } else {

            String actualMessage = loginPage.getErrorMessage();

            Assert.assertTrue(
                    actualMessage.contains(expectedMessage),
                    scenarioDescription + " - Error message is incorrect"
            );
        }

        System.out.println("Finished: " + scenarioDescription);
    }
}
