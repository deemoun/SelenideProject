package org.deemoun;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

class SelenideTests {

    @BeforeEach
    void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void successfulLoginTest() {
        // Navigate to the login page
        open("/");

        // Enter username and password for the standard user
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");

        // Click the login button
        $("#login-button").click();

        // Verify that login was successful by checking that the inventory page is displayed
        $(".inventory_container").shouldBe(visible);
    }
}
