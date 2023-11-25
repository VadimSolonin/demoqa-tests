package tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
public class TextBoxTests extends TestBase {
    @Test
    @Tag("remote")
    void fillAllFormsTest() {
        textBoxPage.openPage(testData.textBoxUrl)
                .setName(testData.userName)
                .setEmail(testData.userEmail)
                .setCurrentAddress(testData.currentAddress)
                .setPermanentAddress(testData.permanentAddress)
                .submitButtonClick();
        verifyTextResultComponent.verifyOutputName(testData.userName)
                .verifyOutputEmail(testData.userEmail)
                .verifyOutputCurrentAddress(testData.currentAddress)
                .verifyOutputPermanentAddress(testData.permanentAddress);
    }

    @Test
    void clickSubmitButtonWithoutWrongEmailTest() {
        textBoxPage.openPage(testData.textBoxUrl)
                .setEmail(testData.userName)
                .submitButtonClick()
                .containsRequiredCssValues("#userEmail");
    }
}
