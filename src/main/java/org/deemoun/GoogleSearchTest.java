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
        open("https://duckduckgo.com"); // Открыть Google
        // Добавить cookies для обхода Google consent

        $("[name=q]").setValue("Selenide").pressEnter(); // Ввести "Selenide" в поиск и нажать Enter
        $$(".g").first().shouldHave(text("Selenide: concise UI tests in Java")); // Проверить, что первый результат содержит текст
    }
}