package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


@Tag("Regress")
public class RegistrationFormTests extends TestBase {

    @Test
    void fillAllFormsAndVerifyResultTest() {
        step("Open form", () -> {
            registrationPage.openPage(testData.automationPracticeUrl);
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(testData.userName)
                    .setLastName(testData.userSurname)
                    .setEmail(testData.userEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubject(testData.subject)
                    .clickFirstTabItem()
                    .selectHobby(testData.hobby)
                    .uploadImage(testData.fileName)
                    .setAddress(testData.currentAddress)
                    .setState(testData.userState)
                    .setCity(testData.userCity)
                    .clickSubmitButton();
        });
        step("Verify test results", () -> {
            verifyTextResultComponent.checkResultWindowHaveText(testData.textInResultWindow)
                    .verifyTableResult("Student Name", testData.userName + " " + testData.userSurname)
                    .verifyTableResult("Student Email", testData.userEmail)
                    .verifyTableResult("Gender", testData.userGender)
                    .verifyTableResult("Mobile", testData.userNumber)
                    .verifyTableResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .verifyTableResult("Subjects", testData.subject)
                    .verifyTableResult("Hobbies", testData.hobby)
                    .verifyTableResult("Picture", testData.fileName)
                    .verifyTableResult("Address", testData.currentAddress)
                    .verifyTableResult("State and City", testData.userState + " " + testData.userCity);
        });

    }

    @Test
    @Tag("RequiredFields")
    void checkRequiredFieldsViewTest() {
        step("Open form", () -> {
            registrationPage.openPage(testData.automationPracticeUrl);
        });
        step("Verify css values", () -> {
            registrationPage.clickSubmitButton()
                    .userFormContainsValidatedClass("was-validated")
                    .containsRequiredCssValues("#firstName")
                    .containsRequiredCssValues("#lastName")
                    .containsRequiredCssValues("#userNumber");
        });
    }

    @Test
    @Tag("RequiredFields")
    void fillUserNumberByLettersTest() {
        step("Open form", () -> {
            registrationPage.openPage(testData.automationPracticeUrl);
        });
        step("Verify css values", () -> {
            registrationPage.setUserNumber(testData.testText)
                    .clickSubmitButton()
                    .containsRequiredCssValues("#userNumber");
        });
    }

}