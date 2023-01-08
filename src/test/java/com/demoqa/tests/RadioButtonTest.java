package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTest {

    @Test
    void radioButtonTest() {
        Configuration.baseUrl = "https://demoqa.com/radio-button";
        open("");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".mb-3").shouldHave(Condition.text("Do you like the site?"));
    }
}
