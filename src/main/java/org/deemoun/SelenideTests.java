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
    void addItemToCartTest() {
        // Login with standard_user
        login("standard_user", "secret_sauce");

        // Verify that we're on the products page
        $(".inventory_container").shouldBe(visible);

        // Select the first item (assuming items are listed and have a common add-to-cart button)
        // The button's ID or class should be verified on the website as it might change
        // For this example, we'll click the first "Add to Cart" button found for an item
        $$(".btn_inventory").first().click();
        $$(".btn_inventory").first().shouldHave(text("REMOVE"));

        // Now, let's check if the item has been added by looking at the cart badge
        // The cart icon should have a badge with a number indicating the items in the cart
        $(".shopping_cart_badge").shouldHave(text("1"));

        // Optional: proceed to checkout and verify item in the cart for a more thorough test

       // logout();
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
