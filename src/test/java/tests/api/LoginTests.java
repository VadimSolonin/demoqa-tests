package tests.api;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import tests.api.apiResponses.AuthorizationApi;
import tests.api.models.LoginModel;
import tests.api.models.LoginResponseModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTests extends TestBase {
    AuthorizationApi authorizationApi = new AuthorizationApi();

    @Test
    void loginTest() {

        LoginModel loginModel = new LoginModel("VS", "1234Qwer!");

        LoginResponseModel loginResponse = authorizationApi.login(loginModel);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));

        open("/profile");
        $("#userName-value").shouldHave(text(loginModel.getUserName()));

    }

}