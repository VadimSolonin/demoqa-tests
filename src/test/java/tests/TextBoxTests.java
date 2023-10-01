package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    @Test
    void fillAllFormsTest() {
        textBoxPage.openPage(testData.TEXT_BOX_URL)
                .setName(testData.USER_NAME)
                .setEmail(testData.USER_EMAIL)
                .setCurrentAddress(testData.CURRENT_ADDRESS)
                .setPermanentAddress(testData.PERMANENT_ADDRESS)
                .submitButtonClick();
        verifyTextResultComponent.verifyOutputName(testData.USER_NAME)
                .verifyOutputEmail(testData.USER_EMAIL)
                .verifyOutputCurrentAddress(testData.CURRENT_ADDRESS)
                .verifyOutputPermanentAddress(testData.PERMANENT_ADDRESS);
    }

    @Test
    void clickSubmitButtonWithoutWrongEmailTest() {
        textBoxPage.openPage(testData.TEXT_BOX_URL)
                .setEmail(testData.USER_NAME)
                .submitButtonClick()
                .containsRequiredCssValues("#userEmail");
    }
}
