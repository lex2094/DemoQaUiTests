package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.demoqa.pages.registrationform.RegistrationFormPage;
import com.demoqa.pages.registrationform.components.ResultsModal;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsModal resultsModal = new ResultsModal();

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

    @Test
    void radioButtonTest() {
        Configuration.baseUrl = "https://demoqa.com/radio-button";
        open("");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".mb-3").shouldHave(Condition.text("Do you like the site?"));
    }


    //подтюнить тесты на календарь
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Other")
                .setNumber(phone)
                //.setBirthDate(generateDay(), generateMonth(), generateYear())
                .setSubjectInput()
                .setHobbiesWrapper()
                .uploadPicture()
                .setCurrentAddress()
                .setState()
                .setCity();
        registrationFormPage.clickSubmit();
        resultsModal.checkVisible();
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName)
                .checkResult("Student Email", email);
        //.checkResult("Date of Birth", generateDay() + " " + generateMonth() + "," + generateYear());
        resultsModal.checkVisible();
        System.out.println("okk");
    }

    @Disabled //ждем правки бага
    @Test
    void checkBoxCollapseTest() {
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
