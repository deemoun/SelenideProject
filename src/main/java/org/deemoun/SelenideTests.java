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
    void addSauceLabsOnesieToCartTest() {
        // Login with standard_user
        login("standard_user", "secret_sauce");

        // Verify that we're on the products page
        $(".inventory_container").shouldBe(visible);

        // Find the "Sauce Labs Onesie" and click its "Add to Cart" button
        // This assumes that each item has a unique name element that can be used to find the specific "Add to Cart" button
        // The actual selectors might need adjustment based on the website's structure
        $$(".inventory_item_name").findBy(text("Sauce Labs Onesie")).parent().$(".btn_inventory").click();

        // Verify that the item has been added to the cart
        $(".shopping_cart_badge").shouldHave(text("1"));

        // Optional: Verify item in the cart page for a comprehensive test

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
