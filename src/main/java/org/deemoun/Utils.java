package org.deemoun;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Utils {

    @BeforeAll
    static void setup() {
        Utils.configureSelenide();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    public static void configureSelenide() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
        // Add any other global configurations you need
    }
}
