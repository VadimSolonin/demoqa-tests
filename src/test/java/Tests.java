import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    public static final String BASE_URL = "https://demoqa.com/automation-practice-form";
    public static final String USER_NAME = "V";
    public static final String USER_SURNAME = "S";
    public static final String USER_EMAIL = "vs@mail.ru";
    public static final String USER_GENDER = "'Male'";
    public static final String USER_NUMBER = "89998887766";
    public static final String YEAR_OF_BIRTH = "1992";
    public static final String MONTH_OF_BIRT = "November";
    public static final String SUBJECT = "Maths";
    public static final String ADDRESS = "Next time ;]";

    @BeforeEach
    void setUp() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open(BASE_URL);
    }

    @Test
    void successfulSearchTest() {
        File vsFile = new File("src/images/vsFile.png");

        $("[id=firstName]").setValue(USER_NAME);
        $("[id=lastName]").setValue(USER_SURNAME);
        $("[id=userEmail]").setValue(USER_EMAIL);
        $(By.xpath("//*[contains(text()," + USER_GENDER + ")]")).click();
        $("[id=userNumber]").setValue(USER_NUMBER);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(MONTH_OF_BIRT);
        $(".react-datepicker__year-select").selectOption(YEAR_OF_BIRTH);
        $(".react-datepicker__day--028").click();
        $("[class=subjects-auto-complete__input]").click();
        $("[id=subjectsInput]").setValue(SUBJECT).pressEnter();
        $(".custom-control.custom-checkbox.custom-control-inline").click();
        $(".form-control-file").uploadFile(vsFile);
        $("[id=currentAddress]").setValue(ADDRESS);
        $("[id=state]").click();
        $("[id=react-select-3-option-2]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        $("[id=submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

}