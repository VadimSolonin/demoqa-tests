package tests.api;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.api.apiResponses.AuthorizationApi;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://demoqa.com/";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
}