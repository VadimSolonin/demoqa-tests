package tests;

import org.junit.jupiter.api.Test;


public class TextBoxTests extends TestBase {

    public static final String TEXT_BOX_URL = "/text-box";
    public static final String USER_NAME = "V";
    public static final String USER_EMAIL = "v@mail.ru";
    public static final String CURRENT_ADDRESS = "Current";
    public static final String PERMANENT_ADDRESS = "Permanent";

    @Test
    void fillAllFormsTest() {
        textBoxPage.openPage(TEXT_BOX_URL)
                .setName(USER_NAME)
                .setEmail(USER_EMAIL)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submitButtonClick();
        verifyTextResultComponent.verifyOutputName(USER_NAME)
                .verifyOutputEmail(USER_EMAIL)
                .verifyOutputCurrentAddress(CURRENT_ADDRESS)
                .verifyOutputPermanentAddress(PERMANENT_ADDRESS);
    }

    @Test
    void clickSubmitButtonWithoutWrongEmailTest() {
        textBoxPage.openPage(TEXT_BOX_URL)
                .setEmail(USER_NAME)
                .submitButtonClick()
                .containsRequiredCssValues("#userEmail");
    }
}
