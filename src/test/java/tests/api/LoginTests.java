package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.ProfilePage;
import tests.api.apiResponses.AuthorizationApi;
import tests.api.models.LoginRequestModel;
import tests.api.models.LoginResponseModel;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

@Owner("VS")
@Tag("api")
public class LoginTests extends TestBase {
    AuthorizationApi authorizationApi = new AuthorizationApi();
    LoginRequestModel loginRequestModel = new LoginRequestModel(TestData.LOGIN, TestData.PASSWORD);
    LoginResponseModel loginResponse = authorizationApi.login(loginRequestModel);
    ProfilePage profilePage = new ProfilePage();

    @Test
    @Tag("api")
    void loginTest() {
        step("Открытие страницы сайта и добавление cookie", () -> {
            open("/favicon.ico");
            getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
            getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
        });
        step("Авторизация и проверка отображения имени", () -> {
            open("/profile");
            profilePage.verifyUserNameValue(loginRequestModel.getUserName());
        });


    }

}
