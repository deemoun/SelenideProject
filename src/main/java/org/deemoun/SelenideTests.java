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
    void successfulLoginStandardUserTest() {
        login("standard_user", "secret_sauce");

        // Verify that login was successful by checking that the inventory page is displayed
        $(".inventory_container").shouldBe(visible);

        //logout();
    }

    @Test
    void successfulLoginProblemUserTest() {
        login("problem_user", "secret_sauce");

        // Verify that login was successful by checking that the inventory page is displayed
        $(".inventory_container").shouldBe(visible);

        //logout();
    }

    private void login(String username, String password) {
        open("/");
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();
    }

    private void logout() {
        open("/"); // Ensure the page is fully loaded
        $("#react-burger-menu-btn").click(); // Open the menu
        $("#logout_sidebar_link").click(); // Click the logout link
    }
}
