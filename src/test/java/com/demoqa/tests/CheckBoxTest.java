package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTest {

    @Test
    void checkBoxNoCollapseTest(){
        String message = "home, desktop, notes, commands, documents, workspace, react, angular, veu, office, public, private, classified, general, downloads, wordFile, excelFile";
        Configuration.baseUrl = "https://demoqa.com";
        open("/checkbox");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".rct-icon-uncheck")
                .click();
        $("#result").shouldBe(visible);
        //$("#result").shouldHave(text("You have selected :"));
        //$$("#result").shouldHave(("home, desktop, notes, commands, documents, workspace, react, angular, veu, office, public, private, classified, general, downloads, wordFile, excelFile"));
    }

    @Test
    void checkBoxCollapseTest(){
            Configuration.baseUrl = "https://demoqa.com";
        open("/checkbox");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".rct-icon-expand-close").click();
        $(".rct-icon-expand-open").click();

        sleep(3000);
    }
}
