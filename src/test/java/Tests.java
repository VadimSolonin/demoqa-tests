import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    public static final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public static final String USER_NAME = "V";
    public static final String USER_SURNAME = "S";
    public static final String USER_EMAIL = "vs@mail.ru";
    public static final String USER_GENDER = "Male";
    public static final String USER_NUMBER = "8999888776";
    public static final String YEAR_OF_BIRTH = "1992";
    public static final String MONTH_OF_BIRTH = "November";
    public static final int DAY_OF_BIRTH = 28;
    public static final String SUBJECT = "Maths";
    public static final String HOBBY = "Sports";
    public static final String USER_STATE = "Haryana";
    public static final String USER_CITY = "Karnal";
    public static final String ADDRESS = "Next time ;]";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillAllForms() {
        open(AUTOMATION_PRACTICE_URL);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(USER_NAME);
        $("#lastName").setValue(USER_SURNAME);
        $("#userEmail").setValue(USER_EMAIL);
        $("#genterWrapper").$(byText(USER_GENDER)).click();
        $("#userNumber").setValue(USER_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MONTH_OF_BIRTH);
        $(".react-datepicker__year-select").selectOption(YEAR_OF_BIRTH);
        $(".react-datepicker__day--0"+DAY_OF_BIRTH).click();
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue(SUBJECT).pressEnter();
        $("#hobbiesWrapper").$(byText(HOBBY)).click();
        $("#uploadPicture").uploadFromClasspath("vsFile.png");
        $("#currentAddress").setValue(ADDRESS);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(USER_STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(USER_CITY)).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(USER_NAME + " " + USER_SURNAME),
                text(USER_EMAIL),
                text(USER_GENDER),
                text(USER_NUMBER),
                text(DAY_OF_BIRTH + " " + MONTH_OF_BIRTH+","+YEAR_OF_BIRTH),
                text(SUBJECT),
                text(HOBBY),
                text("vsFile.png"),
                text(ADDRESS),
                text(USER_STATE + " " + USER_CITY));
    }

}