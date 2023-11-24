package tests.api;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import tests.api.apiResponses.AuthorizationApi;
import tests.api.apiResponses.BooksApi;
import tests.api.models.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfileBooksListTests extends TestBase {
    AuthorizationApi authorizationApi = new AuthorizationApi();
    BooksApi booksApi = new BooksApi();
    LoginModel loginModel = new LoginModel(TestData.LOGIN, TestData.PASSWORD);

    @Test
    void addBookToProfileTest() {
        LoginResponseModel loginResponse = authorizationApi.login(loginModel);
        booksApi.deleteAllBooks(loginResponse);

        IsbnModel isbnModel = new IsbnModel("9781449325862");
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);

        AddBooksListModel booksList = new AddBooksListModel();
        booksList.setUserId(loginResponse.getUserId());
        booksList.setCollectionOfIsbns(isbnList);

        booksApi.addBook(loginResponse, booksList);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));

        open("/profile");
        $("[id='see-book-Git Pocket Guide']").shouldBe(visible);
    }

    @Test
    void deleteBookFromProfileTest() {
        LoginModel loginModel = new LoginModel(TestData.LOGIN, TestData.PASSWORD);
        DeleteBookResponseModel deleteBookModel = new DeleteBookResponseModel("9781449325862", "1bac20f1-55eb-4cdc-b546-957c96333466");
        IsbnModel isbnModel = new IsbnModel("9781449325862");

        LoginResponseModel loginResponse = authorizationApi.login(loginModel);
        booksApi.deleteAllBooks(loginResponse);


        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);

        AddBooksListModel booksList = new AddBooksListModel();
        booksList.setUserId(loginResponse.getUserId());
        booksList.setCollectionOfIsbns(isbnList);

        booksApi.addBook(loginResponse, booksList);
        booksApi.deleteBook(loginResponse, deleteBookModel);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));

        open("/profile");
        $x("//*[contains(text(),'No rows found')]").shouldBe(visible);
    }
}
