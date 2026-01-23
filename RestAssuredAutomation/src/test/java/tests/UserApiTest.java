package tests;

import base.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    @Test
    public void verifyGetUsers() {

        Response response =
                given()
//                        .log().all()
                        .when()
                        .get("/users")
                        .then()
//                        .log().all()
                        .statusCode(200)
                        .extract().response();

        // JSON Path assertions
        String firstUserName = response.jsonPath().getString("[0].name");
        Assert.assertNotNull(firstUserName);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
    }


    @Test
    public void verifyCreateUser() {

        String payload = """
        {
          "name": "John Doe",
          "username": "johnd",
          "email": "john@test.com"
        }
        """;

        Response response =
                given()
//                        .log().all()
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .post("/users")
                        .then()
                        .log().all()
                        .statusCode(201)
                        .extract().response();

        // Assertions
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }
}
