package utility;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ProductsAPI {

    public static ValidatableResponse validatableResponse;

    public static void postMethod(JSONPObject jsonpObject){
        validatableResponse = given()
                .baseUri("https://fakestoreapi.com")
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(jsonpObject.toString())
                .when()
                .post("/products")
                .then()
                .assertThat().statusCode(200);
    }

    public static void getResponse(){
        System.out.println("Response: " +validatableResponse.extract().asPrettyString());
    }
}
