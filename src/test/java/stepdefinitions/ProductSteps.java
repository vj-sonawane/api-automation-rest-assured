package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utility.ProductsAPI;

import static org.junit.Assert.assertEquals;

public class ProductSteps {

    public ProductsAPI productsAPI;

    public RequestSpecification httpRequest;

    public Response response;

    public ResponseBody body;


    @Given("I hit the url of get products api endpoint")
    public void iHitTheUrlOfGetProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @When("I pass the url of products in the request")
    public void iPassTheUrlOfProductsInTheRequest() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("/products");
    }

    @Then("Then I receive the response code as OK")
    public void thenIReceiveTheResponseCodeAsOK() {
        System.out.println("Products Response: " + response.then().extract().asPrettyString());
        System.out.println("Status Code: " + response.getStatusCode());
        assertEquals(200, response.getStatusCode());
    }

    @Then("I verify that the rate of first product is {string}")
    public void iVerifyThatTheRateOfFirstProductIs(String rate) {
        body = response.getBody();
        System.out.println("ProductsResponseBody: "+body.prettyPrint());
        JsonPath path = response.jsonPath();
        System.out.println("RatingObjects: " +path.getJsonObject("rating").toString());
        System.out.println("FirstProductRate: "+path.getJsonObject("rating[0].rate").toString());
        assertEquals(rate, path.getJsonObject("rating[0].rate").toString());
    }
}
