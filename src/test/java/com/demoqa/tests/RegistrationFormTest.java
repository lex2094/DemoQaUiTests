package com.demoqa.tests;

import com.demoqa.pages.registrationform.RegistrationFormPage;
import com.demoqa.pages.registrationform.components.ResultsModal;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsModal resultsModal = new ResultsModal();

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
}
