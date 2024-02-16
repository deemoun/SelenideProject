package org.deemoun;

import com.codeborne.selenide.Configuration;

public class Utils {

    public static void configureSelenide() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
        // Add any other global configurations you need
    }
}
