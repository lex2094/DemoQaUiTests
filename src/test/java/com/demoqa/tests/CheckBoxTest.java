package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
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
        //String ownText = $("#result").getSelectedOptionText();
        //System.out.println(message);
        //System.out.println(ownText);
    }
    @Disabled
    @Test
    void checkBoxCollapseTest(){
        Configuration.baseUrl = "https://demoqa.com";
        open("/checkbox");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".rct-icon-expand-close").click();
        //sleep(1000);
        //$(".rct-icon-expand-open").click();
        //sleep(3000);
        $(".rct-node-collapsed:nth-child(1) .rct-collapse path").click();
        sleep(1000);
        //$(".rct-icon-expand-close").sibling(1);
        //sleep(3000);
    }
}
