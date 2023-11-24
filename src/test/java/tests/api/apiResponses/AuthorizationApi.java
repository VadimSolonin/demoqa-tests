package tests.api.apiResponses;

import tests.api.models.LoginModel;
import tests.api.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
public class AuthorizationApi {
    public LoginResponseModel login(LoginModel loginModel){
        return given()
                .body(loginModel)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}
