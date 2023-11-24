//package tests.api.extensions;
//
//import org.junit.jupiter.api.extension.BeforeEachCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.openqa.selenium.Cookie;
//import tests.api.apiResponses.AuthorizationApi;
//import tests.api.models.LoginModel;
//import tests.api.models.LoginResponseModel;
//
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
//public class LoginExtension implements BeforeEachCallback {
//    LoginModel loginModel = new LoginModel("VS", "1234Qwer!");
//    AuthorizationApi authorizationApi = new AuthorizationApi();
//    @Override
//    public void beforeEach(ExtensionContext context) {
//
//        LoginResponseModel loginResponse = authorizationApi.login(loginModel);
//        open("/favicon.ico");
//        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
//        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
//        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
//    }
//}
