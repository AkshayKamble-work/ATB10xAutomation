package practies;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetRequestBDDStyle {
    @Test
    public void Test_get()
    {
        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .assertThat().statusLine("HTTP/1.1 200 OK");

    }
}
