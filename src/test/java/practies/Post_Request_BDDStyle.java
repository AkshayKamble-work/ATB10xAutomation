package practies;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Post_Request_BDDStyle {
    @Test
    public void Test_Post()
    { String payload="{\n" +
            "    \"name\": \"Akshay\",\n" +
            "    \"job\": \"Senior QA\"\n" +
            "}";
        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(payload).log().all()
                .when()
                .post()
                .then().log().all().assertThat()
                .statusCode(201).
                assertThat().statusLine("HTTP/1.1 201 Created");
    }

}
