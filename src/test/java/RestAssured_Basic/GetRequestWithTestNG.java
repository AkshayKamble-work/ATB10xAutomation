package RestAssured_Basic;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetRequestWithTestNG {


    @Test
    public void VerifyGet()
    {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/413512")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


    }
    @Test
    public void Verify()
    {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/413512")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

}
