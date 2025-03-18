package practies;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Post_Request_NonBDD {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validateResponse;
    String payload = "{\n" +
            "    \"name\": \"Akshay\",\n" +
            "    \"job\": \"Senior QA\"\n" +
            "}";

    @Test
    public void Test_Post() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().post();

        response.then().log().all().statusCode(201).statusLine("HTTP/1.1 201 Created");


    }
}