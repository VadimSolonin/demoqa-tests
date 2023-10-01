package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {

    @Test
    void fillAllFormsAndVerifyResultTest() {
        registrationPage.openPage(testData.AUTOMATION_PRACTICE_URL)
                .setFirstName(testData.USER_NAME)
                .setLastName(testData.USER_SURNAME)
                .setEmail(testData.USER_EMAIL)
                .setGender(testData.USER_GENDER)
                .setUserNumber(testData.USER_NUMBER)
                .setDateOfBirth(testData.DAY_OF_BIRTH, testData.MONTH_OF_BIRTH, testData.YEAR_OF_BIRTH)
                .setSubject(testData.SUBJECT)
                .selectHobby(testData.HOBBY)
                .uploadImage(testData.FILE_NAME)
                .setAddress(testData.CURRENT_ADDRESS)
                .setState(testData.USER_STATE)
                .setCity(testData.USER_CITY)
                .clickSubmitButton();
        verifyTextResultComponent.checkResultWindowHaveText(testData.TEXT_IN_RESULT_WINDOW)
                .verifyTableResult(testData.USER_NAME + " " + testData.USER_SURNAME)
                .verifyTableResult(testData.USER_EMAIL)
                .verifyTableResult(testData.USER_GENDER)
                .verifyTableResult(testData.USER_NUMBER)
                .verifyTableResult(testData.DAY_OF_BIRTH + " " + testData.MONTH_OF_BIRTH + "," + testData.YEAR_OF_BIRTH)
                .verifyTableResult(testData.SUBJECT)
                .verifyTableResult(testData.HOBBY)
                .verifyTableResult(testData.FILE_NAME)
                .verifyTableResult(testData.CURRENT_ADDRESS)
                .verifyTableResult(testData.USER_STATE + " " + testData.USER_CITY);
    }

    @Test
    void checkRequiredFieldsViewTest() {
        registrationPage.openPage(testData.AUTOMATION_PRACTICE_URL)
                .clickSubmitButton()
                .userFormContainsValidatedClass("was-validated")
                .containsRequiredCssValues("#firstName")
                .containsRequiredCssValues("#lastName")
                .containsRequiredCssValues("#userNumber");
    }

    @Test
    void fillUserNumberByLettersTest() {
        registrationPage.openPage(testData.AUTOMATION_PRACTICE_URL)
                .setUserNumber(testData.TEST_TEXT)
                .clickSubmitButton()
                .containsRequiredCssValues("#userNumber");
    }

}