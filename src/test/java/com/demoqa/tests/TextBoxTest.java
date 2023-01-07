package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {


    @Test
    void fillTextBox() {
        Configuration.baseUrl = "https://demoqa.com";
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#userName").setValue("Alexey Ch");
        $("#userEmail").setValue("11@mail.ru");
        $("#currentAddress").setValue("1111");
        $("#permanentAddress").setValue("1222");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").shouldHave(text("Name:Alexey Ch"));
        $("#output").shouldHave(text("Email:11@mail.ru"));
        $("#output").shouldHave(text("Current Address :1111"));
        $("#output").shouldHave(text("Permananet Address :1222"));
    }
}
