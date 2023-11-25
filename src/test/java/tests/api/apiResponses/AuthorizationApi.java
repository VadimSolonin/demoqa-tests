package tests.api.apiResponses;

import tests.api.models.LoginRequestModel;
import tests.api.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
public class AuthorizationApi {
    public LoginResponseModel login(LoginRequestModel loginRequestModel){
        return given()
                .body(loginRequestModel)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}
