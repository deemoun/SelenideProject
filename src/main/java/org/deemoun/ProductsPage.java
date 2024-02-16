package org.deemoun;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    public ProductsPage addFirstItemToCart() {
        $$(".btn_inventory").first().click();
        return this;
    }

    public ProductsPage addSpecificItemToCart(String itemName) {
        $$(".inventory_item_name").findBy(text(itemName)).parent().$(".btn_inventory").click();
        return this;
    }

    public boolean isItemAdded() {
        return $(".shopping_cart_badge").exists();
    }
    // Additional functionalities as needed, e.g., navigation to cart, item verification
}

