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
    // Additional functionalities as needed, e.g., navigation to cart, item verification
}

