
package saucedemo.pages;

import saucedemo.actions.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Private locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Composition
    private PageActions actions;

    public LoginPage(WebDriver driver) {

        actions = new PageActions(driver);
    }

    public void login(String username, String password) {

        actions.type(usernameField, username);

        actions.type(passwordField, password);

        actions.click(loginButton);
    }

    public String getErrorMessage() {

        return actions.getText(errorMessage);
    }
}
