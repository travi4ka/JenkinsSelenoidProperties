package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static testData.TestData.*;

public class Tests extends TestsBase {
    @Test
    @Tag("example")
    public void fillOutForm() {
        automationPracticeFormPage
                .openPage()
                .setUserFirstNameInput(nameFirst)
                .setUserLastNameInput(nameLast)
                .setUserEmailInput(email)
                .setUserPhoneInput(phone)
                .setUserGenderSection(gender)
                .setUserBOD(birthDateDay, birthDateMonth, birthDateYear)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setImage(pictureName)
                .setCurrentAddressInput(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()
                .verifyTableValues("Student Name", nameFirst + " " + nameLast)
                .verifyTableValues("Student Email", email)
                .verifyTableValues("Gender", gender)
                .verifyTableValues("Mobile", phone)
                .verifyTableValues("Date of Birth", birthDateDay + " " + birthDateMonth + "," + birthDateYear)
                .verifyTableValues("Hobbies", hobby)
                .verifyTableValues("Picture", pictureName)
                .verifyTableValues("Address", currentAddress)
                .verifyTableValues("State and City", state + " " + city)
                .verifyTableValues("Subjects", subject);
    }
}
