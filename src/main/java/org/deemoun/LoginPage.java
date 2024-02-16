package org.deemoun;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        $("#user-name").setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        $("#login-button").click();
        return new ProductsPage();
    }

    // Include a method for any login validation if necessary
}

