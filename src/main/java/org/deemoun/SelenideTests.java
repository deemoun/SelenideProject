package org.deemoun;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.deemoun.LoginPage;
import org.deemoun.ProductsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelenideTests {

    @BeforeAll
    static void setup() {
     Utils.configureSelenide();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void addSauceLabsOnesieToCartTest() {
        // Login
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = loginPage.openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();

        // Add "Sauce Labs Onesie" to cart
        productsPage.addSpecificItemToCart("Sauce Labs Onesie");

        // Verify the item was added
        assertTrue(productsPage.isItemAdded());
    }
}
