package org.deemoun;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleSearchTest {

    @BeforeAll
    public static void setup() {
        Utils.configureSelenide();
    }

    @Test
    public void userCanSearch() {
        open("https://google.com"); // Открыть Google
        // Добавить cookies для обхода Google consent
        executeJavaScript("document.cookie = 'CONSENT=YES+cb.20210328-17-p0.en+FX+941;'");

        $("[name=q]").setValue("Selenide").pressEnter(); // Ввести "Selenide" в поиск и нажать Enter
        $$(".g").first().shouldHave(text("Selenide: concise UI tests in Java")); // Проверить, что первый результат содержит текст
    }
}