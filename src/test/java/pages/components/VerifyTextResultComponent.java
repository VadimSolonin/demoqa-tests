package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyTextResultComponent {


    SelenideElement resultWindowTitle = $("#example-modal-sizes-title-lg"),
            outputName = $("#output").$("#name"),
            outputEmail = $("#output").$("#email"),
            outputCurrentAddress = $("#output").$("#currentAddress"),
            outputPermanentAddress = $("#output").$("#permanentAddress");

    public VerifyTextResultComponent checkResultWindowHaveText(String text) {
        resultWindowTitle.shouldHave(text(text));
        return this;
    }

    public VerifyTextResultComponent verifyTableResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public VerifyTextResultComponent verifyOutputName(String text) {
        outputName.shouldHave(
                text(text));
        return this;
    }

    public VerifyTextResultComponent verifyOutputEmail(String text) {
        outputEmail.shouldHave(
                text(text));
        return this;
    }

    public VerifyTextResultComponent verifyOutputCurrentAddress(String text) {
        outputCurrentAddress.shouldHave(
                text(text));
        return this;
    }

    public VerifyTextResultComponent verifyOutputPermanentAddress(String text) {
        outputPermanentAddress.shouldHave(
                text(text));
        return this;
    }
}
