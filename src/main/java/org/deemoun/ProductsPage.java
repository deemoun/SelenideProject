package org.deemoun;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    public ProductsPage addFirstItemToCart() {
        $$(".btn_inventory").first().click();
        return this;
    }

    public void addSpecificItemToCart(String itemName) {
        // Find the item by its name and click the associated "Add to Cart" button
        SelenideElement item = $$(".inventory_item").filter(text(itemName)).first();
        item.find(".btn_inventory").click();
    }

    public boolean isItemAdded() {
        return $(".shopping_cart_badge").exists();
    }

    public LoginPage logout() {
        // Click the menu button to open the dropdown or navigation menu
        $("#react-burger-menu-btn").click();

        // Click the logout link within the opened menu
        // Ensure the ID or class used for the logout link matches the actual element
        $("#logout_sidebar_link").click();

        // Return a new instance of the LoginPage as the user should be redirected to the login page after logging out
        return new LoginPage();
    }
    public void openCart() {
        // Click the cart icon to navigate to the cart page
        $(".shopping_cart_link").click();
    }
    // Additional functionalities as needed, e.g., navigation to cart, item verification
}

