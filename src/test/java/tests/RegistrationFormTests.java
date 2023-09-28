package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {

    public static final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public static final String USER_NAME = "V";
    public static final String USER_SURNAME = "S";
    public static final String USER_EMAIL = "vs@mail.ru";
    public static final String USER_GENDER = "Male";
    public static final String USER_NUMBER = "8999888776";
    public static final String YEAR_OF_BIRTH = "1992";
    public static final String MONTH_OF_BIRTH = "November";
    public static final String DAY_OF_BIRTH = "28";
    public static final String SUBJECT = "Maths";
    public static final String HOBBY = "Sports";
    public static final String FILE_NAME = "vsFile.png";
    public static final String USER_STATE = "Haryana";
    public static final String USER_CITY = "Karnal";
    public static final String ADDRESS = "Next time ;]";
    public static final String TEST_TEXT = "Notanumber";
    public static final String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";


    @Test
    void fillAllFormsAndVerifyResultTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .setFirstName(USER_NAME)
                .setLastName(USER_SURNAME)
                .setEmail(USER_EMAIL)
                .setGender(USER_GENDER)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DAY_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH)
                .setSubject(SUBJECT)
                .selectHobby(HOBBY)
                .uploadImage(FILE_NAME)
                .setAddress(ADDRESS)
                .setState(USER_STATE)
                .setCity(USER_CITY)
                .clickSubmitButton();
        verifyTextResultComponent.checkResultWindowHaveText(TEXT_IN_RESULT_WINDOW)
                .verifyTableResult(USER_NAME + " " + USER_SURNAME)
                .verifyTableResult(USER_EMAIL)
                .verifyTableResult(USER_GENDER)
                .verifyTableResult(USER_NUMBER)
                .verifyTableResult(DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                .verifyTableResult(SUBJECT)
                .verifyTableResult(HOBBY)
                .verifyTableResult(FILE_NAME)
                .verifyTableResult(ADDRESS)
                .verifyTableResult(USER_STATE + " " + USER_CITY);
    }

    @Test
    void checkRequiredFieldsViewTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .clickSubmitButton()
                .userFormContainsValidatedClass("was-validated")
                .containsRequiredCssValues("#firstName")
                .containsRequiredCssValues("#lastName")
                .containsRequiredCssValues("#userNumber");
    }

    @Test
    void fillUserNumberByLettersTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .setUserNumber(TEST_TEXT)
                .clickSubmitButton()
                .containsRequiredCssValues("#userNumber");
    }

}