import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    @Test
    void successfulSearchTest() {
        File vsFile = new File("src/images/vsFile.png");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("V");
        $("[id=lastName]").setValue("S");
        $("[id=userEmail]").setValue("vs@mail.ru");
        $(By.xpath("//*[contains(text(),'Male')]")).click();
        $("[id=userNumber]").setValue("89998887766");
        $("[id=dateOfBirthInput]").click();
        $("[value=\"10\"]").click();
        $("[value=\"1992\"]").click();
        $("[aria-label='Choose Saturday, November 28th, 1992']").click();
        $("[class=subjects-auto-complete__input]").click();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $(".custom-control.custom-checkbox.custom-control-inline").click();
        $(".form-control-file").uploadFile(vsFile);
        $("[id=currentAddress]").setValue("ffffffffffff");
        $("[id=state]").click();
        $("[id=react-select-3-option-2]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        $("[id=submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

}