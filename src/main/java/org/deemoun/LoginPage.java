package org.deemoun;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    // Locators
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        // Use the locator variable
        $(usernameInput).setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        // Use the locator variable
        $(passwordInput).setValue(password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        // Use the locator variable
        $(loginButton).click();
        return new ProductsPage();
    }

    // Include a method for any login validation if necessary
}


