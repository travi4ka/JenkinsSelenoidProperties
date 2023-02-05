package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    private SelenideElement
            userFirstNameInput = $("#firstName"),
            userLastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderSection = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            calendarSection = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            subjectsContainerAutoCompleteList = $(".subjects-auto-complete__menu"),
            hobbiesSection = $("#hobbiesWrapper"),
            imageUpdateField = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateField = $(byText("Select State")),
            cityField = $("#city"),
            submitButton = $("button#submit");


    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public AutomationPracticeFormPage setUserFirstNameInput(String value) {
        userFirstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserLastNameInput(String value) {
        userLastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserPhoneInput(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserGenderSection(String value) {
        userGenderSection.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserBOD(String day, String month, String year) {
        calendarSection.click();
        new CalendarComponent().setDOB(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubjects(String... value) {
        for (String subject : value) {
            subjectsContainerInput.setValue(subject);
            subjectsContainerAutoCompleteList.$(byText(subject)).click();
        }
        return this;
    }

    public AutomationPracticeFormPage setHobbies(String... value) {
        for (String hobby : value) {
            hobbiesSection.$(byText(hobby)).click();
        }
        return this;
    }

    public AutomationPracticeFormPage setImage(String fileName) {
        imageUpdateField.uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public AutomationPracticeFormPage setState(String state) {
        stateField.click();
        $(byText(state)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String city) {
        cityField.click();
        $(byText(city)).click();
        return this;
    }

    public AutomationPracticeFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage verifyTableValues(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }
}
