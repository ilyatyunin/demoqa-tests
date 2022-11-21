package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void configure1() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
//        $("[id=userName]").setValue("Ilya");
        $("#userName").setValue("Ilya");
        $("#userEmail").setValue("Ilya@name.com");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Bali");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Ilya"));
        $("#output #email").shouldHave(text("Ilya@name.com"));
        $("#output #currentAddress").shouldHave(text("Moscow"));
        $("#output #permanentAddress").shouldHave(text("Bali"));

    }


}
