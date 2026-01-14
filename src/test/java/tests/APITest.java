package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void getBooks(){

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books");

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
        response.getBody().prettyPeek();
    }
}
