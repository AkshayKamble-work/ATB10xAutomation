package RestAssured_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Assertion {

    RequestSpecification requestSpec;
    Response response;
    ValidatableResponse validateResponse;
    String bookingID;

    @Test
    public void Test_Post() {
        String payload = "{\n" +
                "    \"firstname\" : \"Ashwini\",\n" +
                "    \"lastname\" : \"Kamble\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpec = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all();

        response = requestSpec.when().post();

        validateResponse = response.then().log().all();
        validateResponse.statusCode(200);

        validateResponse.body("booking.firstname", Matchers.equalTo("Ashwini"));
        validateResponse.body("booking.lastname", Matchers.equalTo("Kamble"));
        validateResponse.body("booking.totalprice", Matchers.equalTo(111));
        validateResponse.body("booking.depositpaid", Matchers.equalTo(true));
    }
}
