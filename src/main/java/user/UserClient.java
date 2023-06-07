package user;

import data.User;
import extensions.Endpoints;
import extensions.Specifications;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.hamcrest.Matchers.is;

public class UserClient{
    @Step("Send post request to api/auth/login")
    public ValidatableResponse login(User user) {
        return given()
                .spec(Specifications.requestSpecification())
                .and()
                .body(user)
                .when()
                .post(Endpoints.LOGIN_API)
                .then();
    }

    @Step("Send delete request to api/auth/user")
    public ValidatableResponse delete(String bearerToken) {
        return given()
                .spec(Specifications.requestSpecification())
                .headers("Authorization", bearerToken)
                .delete(Endpoints.DELETE_USER_API)
                .then()
                .statusCode(SC_ACCEPTED)
                .and()
                .body("message", is("User successfully removed"));
    }
    @Step("Send post request to api/auth/register")
    public ValidatableResponse create(User user) {
        return given()
                .spec(Specifications.requestSpecification())
                .and()
                .body(user)
                .when()
                .post(Endpoints.CREATE_USER_API)
                .then();
    }
}