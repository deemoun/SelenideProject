package org.deemoun;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

class SelenideTests {

    @BeforeEach
    void setup() {
        Utils.configureSelenide();
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

        // Directly click the "Add to Cart" button for the "Sauce Labs Onesie"
        // Assuming the button for the "Sauce Labs Onesie" has a unique data-test attribute or class
        // For illustration, let's assume there's a data-test attribute like 'data-test="add-to-cart-sauce-labs-onesie"'
        // Adjust the selector based on the actual attribute or class used on the website
        $("[data-test='add-to-cart-sauce-labs-onesie']").click();

        // Verify that the item has been added to the cart
        $(".shopping_cart_badge").shouldHave(text("1"));

        // Optional: Verify item in the cart page for a comprehensive test

        logout();
    }

    private void login(String username, String password) {
        open("/");
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();
    }

    private void logout() {
        // Attempt to navigate to the base URL or dashboard, where the logout button is expected to be accessible

        // Wait for the element to be visible with an explicit wait
        // Replace with a more specific condition if there's a better indicator of page readiness
        $("#react-burger-menu-btn").shouldBe(visible, Duration.ofSeconds(10));

        if ($("#react-burger-menu-btn").is(visible)) {
            $("#react-burger-menu-btn").click();
            $("#logout_sidebar_link").shouldBe(visible).click();
        } else {
            System.out.println("Failed to find the logout button. Check if UI has changed.");
            // Consider throwing an exception or handling the error based on your test requirements
        }
    }

}
